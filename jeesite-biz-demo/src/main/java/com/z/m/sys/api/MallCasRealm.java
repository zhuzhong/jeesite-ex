/**
 * 
 */
package com.z.m.sys.api;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cas.CasAuthenticationException;
import org.apache.shiro.cas.CasRealm;
import org.apache.shiro.cas.CasToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.StringUtils;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.validation.Assertion;
import org.jasig.cas.client.validation.TicketValidationException;
import org.jasig.cas.client.validation.TicketValidator;

import com.alibaba.fastjson.JSON;
import com.z.jeesite.sys.api.CasUserService;
import com.z.jeesite.sys.api.dto.CasUser;


/**
 * 商城后台与cas，shiro集成的类
 * 
 * @author zhuzhong
 *
 */
public class MallCasRealm extends CasRealm {

	public MallCasRealm() {
		super();
	}

	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		CasToken casToken = (CasToken) token;
		if (token == null)
			return null;
		String ticket = (String) casToken.getCredentials();
		if (!StringUtils.hasText(ticket))
			return null;
		TicketValidator ticketValidator = ensureTicketValidator();
		try {
			Assertion casAssertion = ticketValidator.validate(ticket, getCasService());
			// casPrincipal 认证后的用户信息
			AttributePrincipal casPrincipal = casAssertion.getPrincipal();
			String userId = casPrincipal.getName();

			// 获取用户
			CasUser user = casUserService.getUserByLoginName(userId);

			Map<String, Object> attributes = casPrincipal.getAttributes();
			casToken.setUserId(userId);
			String rememberMeAttributeName = getRememberMeAttributeName();
			String rememberMeStringValue = (String) attributes.get(rememberMeAttributeName);
			boolean isRemembered = rememberMeStringValue != null && Boolean.parseBoolean(rememberMeStringValue);
			if (isRemembered)
				casToken.setRememberMe(true);
			// List principals = CollectionUtils.asList(new Object[] { userId,
			// attributes });
			// PrincipalCollection principalCollection = new
			// SimplePrincipalCollection(principals, getName());
			// 这里可以拿到Cas的登录账号信息,加载到对应权限体系信息放到缓存中...
			return new SimpleAuthenticationInfo(new Principal(user, false), ticket, getName());
		} catch (TicketValidationException e) {
			throw new CasAuthenticationException(
					(new StringBuilder()).append("Unable to validate ticket [").append(ticket).append("]").toString(),
					e);
		}
	}

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		Principal principal = (Principal) getAvailablePrincipal(principals);

		CasUser user =principal.getCasUser();
		if (user != null) {
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			/*List<Menu> list = UserUtils.getMenuList();
			for (Menu menu : list) {
				if (org.apache.commons.lang3.StringUtils.isNotBlank(menu.getPermission())) {
					// 添加基于Permission的权限信息
					for (String permission : org.apache.commons.lang3.StringUtils.split(menu.getPermission(), ",")) {
						info.addStringPermission(permission);
					}
				}
			}*/
			if(user.getPermissions()!=null&&user.getPermissions().size()>0){
				for(String p:user.getPermissions()){
					if (org.apache.commons.lang3.StringUtils.isNotBlank(p)) {
						// 添加基于Permission的权限信息
						for (String permission : org.apache.commons.lang3.StringUtils.split(p, ",")) {
							info.addStringPermission(permission);
						}
					}
				}
			}
			
			info.addStringPermission("invoice:invoice:edit");
			info.addStringPermission("invoice:invoice:view");
			// 添加用户权限
			info.addStringPermission("user");
			// 添加用户角色信息
			/*for (Role role : user.getRoleList()) {
				info.addRole(role.getEnname());
			}*/
			if(user.getRoleEnNames()!=null&&user.getRoleEnNames().size()>0){
				for(String role:user.getRoleEnNames()){
					info.addRole(role);
				}
			}
			// 更新登录IP和时间
			//getSystemService().updateUserLoginInfo(user);
			// 记录登录日志
			//LogUtils.saveLog(Servlets.getRequest(), "系统登录");
			System.out.println(JSON.toJSONString(info));
			return info;
		} else {
			return null;
		}

	}

	@Override
	protected void checkPermission(Permission permission, AuthorizationInfo info) {
		authorizationValidate(permission);
		super.checkPermission(permission, info);
	}

	@Override
	protected boolean[] isPermitted(List<Permission> permissions, AuthorizationInfo info) {
		if (permissions != null && !permissions.isEmpty()) {
			for (Permission permission : permissions) {
				authorizationValidate(permission);
			}
		}
		return super.isPermitted(permissions, info);
	}

	@Override
	public boolean isPermitted(PrincipalCollection principals, Permission permission) {
		authorizationValidate(permission);
		return super.isPermitted(principals, permission);
	}

	@Override
	protected boolean isPermittedAll(Collection<Permission> permissions, AuthorizationInfo info) {
		if (permissions != null && !permissions.isEmpty()) {
			for (Permission permission : permissions) {
				authorizationValidate(permission);
			}
		}
		return super.isPermittedAll(permissions, info);
	}

	/**
	 * 授权验证方法
	 * 
	 * @param permission
	 */
	private void authorizationValidate(Permission permission) {
		// 模块授权预留接口
	}

	/**
	 * 授权用户信息
	 */
	public static class Principal implements Serializable {

		private static final long serialVersionUID = 1L;

		private final String id; // 编号
		private final String loginName; // 登录名
		private final String name; // 姓名
		private final boolean mobileLogin; // 是否手机登录
		private final CasUser casUser;

		// private Map<String, Object> cacheMap;

		public Principal(CasUser user, boolean mobileLogin) {
			this.id = user.getId();
			this.loginName = user.getLoginName();
			this.name = user.getName();
			this.mobileLogin = mobileLogin;
			this.casUser = user;
		}

		public String getId() {
			return id;
		}

		public String getLoginName() {
			return loginName;
		}

		public String getName() {
			return name;
		}

		public boolean isMobileLogin() {
			return mobileLogin;
		}

		// @JsonIgnore
		// public Map<String, Object> getCacheMap() {
		// if (cacheMap==null){
		// cacheMap = new HashMap<String, Object>();
		// }
		// return cacheMap;
		// }

		public CasUser getCasUser() {
			return casUser;
		}

		
		 /**
         * 获取SESSIONID
         */
        public String getSessionid() {
            try {
                return (String) getSession().getId();
            } catch (Exception e) {
                return "";
            }
        }

        
        public static Session getSession() {
            try {
                Subject subject = SecurityUtils.getSubject();
                Session session = subject.getSession(false);
                if (session == null) {
                    session = subject.getSession();
                }
                if (session != null) {
                    return session;
                }
                // subject.logout();
            } catch (Exception e) {

            }
            return null;
        }
        
		@Override
		public String toString() {
			return id;
		}

	}

	private CasUserService casUserService;

	public void setCasUserService(CasUserService casUserService) {
		this.casUserService = casUserService;
	}

}
