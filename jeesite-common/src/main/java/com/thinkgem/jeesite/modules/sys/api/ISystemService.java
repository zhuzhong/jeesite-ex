package com.thinkgem.jeesite.modules.sys.api;

import java.util.Collection;
import java.util.List;

import org.apache.shiro.session.Session;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.sys.entity.Menu;
import com.thinkgem.jeesite.modules.sys.entity.Role;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.security.SystemAuthorizingRealm.Principal;

public interface ISystemService {

	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	public static final int SALT_SIZE = 8;

	//Menu getMenu(String id);

	//List<Menu> findAllMenu();

	//void saveMenu(Menu menu);

	//void deleteMenu(Menu menu);

	//void updateMenuSort(Menu menu);

	//Role getRole(String id);

	List<Role> findAllRole();

	//void saveRole(Role role);

	//void deleteRole(Role role);

	//List<User> findUser(User user);

	//Page<User> findUser(Page<User> page, User user);

	//User getUser(String userId);

	//Boolean outUserInRole(Role role, User user);

	//User assignUserToRole(Role role, User user);

	//Role getRoleByName(String name);

	//Role getRoleByEnname(String enname);

	//String entryptPassword(String newPassword);

	//void saveUser(User user);

	//void deleteUser(User user);

	User getUserByLoginName(String loginName);

	//void updateUserInfo(User currentUser);

	//boolean validatePassword(String oldPassword, String password);

	//void updatePasswordById(String id, String loginName, String newPassword);

	//List<User> findUserByOfficeId(String officeId);

	// {getSystemService().getSessionDao().getActiveSessions}
	Collection<Session> getActiveSessions(boolean b, Principal principal, Session session);

	void delete(Session session); // getSystemService().getSessionDao().delete

	Collection<Session> getActiveSessions(boolean b);

	void updateUserLoginInfo(User user);

}
