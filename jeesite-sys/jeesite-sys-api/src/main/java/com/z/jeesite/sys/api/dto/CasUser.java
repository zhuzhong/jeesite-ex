/**
 * 
 */
package com.z.jeesite.sys.api.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuzhong
 *
 */
public class CasUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5532466020930481356L;
	private String id; // 编号
	private String loginName; // 登录名
	private String name; // 姓名
	private String loginFlag; // 是否允许登陆

	private List<String> permissions; // 权限标识,即menu表对应的标识权限

	private List<String> roleEnNames;// 角色对应的英文名称

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoginFlag() {
		return loginFlag;
	}

	public void setLoginFlag(String loginFlag) {
		this.loginFlag = loginFlag;
	}

	public List<String> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<String> permissions) {
		this.permissions = permissions;
	}

	public List<String> getRoleEnNames() {
		return roleEnNames;
	}

	public void setRoleEnNames(List<String> roleEnNames) {
		this.roleEnNames = roleEnNames;
	}

	public void addPermission(String permisson) {
		if (permissions == null) {
			permissions = new ArrayList<String>();
		}
		permissions.add(permisson);
	}

	public void addRoleEnName(String enName) {
		if (roleEnNames == null) {
			roleEnNames = new ArrayList<String>();
		}
		roleEnNames.add(enName);
	}
}
