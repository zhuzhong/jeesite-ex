/**
 * 
 */
package com.thinkgem.jeesite.modules.sys.service.impl;

import java.util.Collection;
import java.util.List;

import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.modules.sys.api.ISystemService;
import com.thinkgem.jeesite.modules.sys.entity.Role;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.security.SystemAuthorizingRealm.Principal;

/**
 * @author sunff
 *
 */
@Service
@Transactional(readOnly = true)
public class SystemServiceImpl implements ISystemService{

	
	@Autowired
	private SystemService systemService;
	
	/*@Override
	public Menu getMenu(String id) {
		// TODO Auto-generated method stub
		return systemService.getMenu(id);
	}

	@Override
	public List<Menu> findAllMenu() {
		// TODO Auto-generated method stub
		return systemService.findAllMenu();
	}

	@Transactional(readOnly = false)
	@Override
	public void saveMenu(Menu menu) {
		// TODO Auto-generated method stub
		systemService.saveMenu(menu);
	}

	@Transactional(readOnly = false)
	@Override
	public void deleteMenu(Menu menu) {
		// TODO Auto-generated method stub
		systemService.deleteMenu(menu);
	}*/

	/*@Transactional(readOnly = false)
	@Override
	public void updateMenuSort(Menu menu) {
		// TODO Auto-generated method stub
		systemService.updateMenuSort(menu);
	}

	@Override
	public Role getRole(String id) {
		// TODO Auto-generated method stub
		return systemService.getRole(id);
	}



	@Transactional(readOnly = false)
	@Override
	public void saveRole(Role role) {
		// TODO Auto-generated method stub
		systemService.saveRole(role);
	}*/

	@Override
	public List<Role> findAllRole() {
		// TODO Auto-generated method stub
		return systemService.findAllRole();
	}
	
	/*@Transactional(readOnly = false)
	@Override
	public void deleteRole(Role role) {
		// TODO Auto-generated method stub
		systemService.deleteRole(role);
	}

	@Override
	public List<User> findUser(User user) {
		// TODO Auto-generated method stub
		return systemService.findUser(user);
	}

	@Override
	public Page<User> findUser(Page<User> page, User user) {
		// TODO Auto-generated method stub
		return systemService.findUser(page, user);
	}
*/
	/*@Override
	public User getUser(String userId) {
		// TODO Auto-generated method stub
		return systemService.getUser(userId);
	}

	@Override
	public Boolean outUserInRole(Role role, User user) {
		// TODO Auto-generated method stub
		return systemService.outUserInRole(role, user);
	}

	@Override
	public User assignUserToRole(Role role, User user) {
		// TODO Auto-generated method stub
		return systemService.assignUserToRole(role, user);
	}

	@Override
	public Role getRoleByName(String name) {
		// TODO Auto-generated method stub
		return systemService.getRoleByName(name);
	}

	@Override
	public Role getRoleByEnname(String enname) {
		// TODO Auto-generated method stub
		return systemService.getRoleByEnname(enname);
	}
*/
	/*@Override
	public String entryptPassword(String newPassword) {
		// TODO Auto-generated method stub
		return SystemService.entryptPassword(newPassword);
	}
	@Transactional(readOnly = false)
	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		systemService.saveUser(user);
	}
	@Transactional(readOnly = false)
	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		systemService.deleteUser(user);
	}*/

	@Override
	public User getUserByLoginName(String loginName) {
		// TODO Auto-generated method stub
		return systemService.getUserByLoginName(loginName);
	}

	/*@Transactional(readOnly = false)
	@Override
	public void updateUserInfo(User currentUser) {
		// TODO Auto-generated method stub
		systemService.updateUserInfo(currentUser);
	}

	@Override
	public boolean validatePassword(String oldPassword, String password) {
		// TODO Auto-generated method stub
		return SystemService.validatePassword(oldPassword, password);
	}

	@Transactional(readOnly = false)
	@Override
	public void updatePasswordById(String id, String loginName, String newPassword) {
		// TODO Auto-generated method stub
		systemService.updatePasswordById(id, loginName, newPassword);
	}

	@Override
	public List<User> findUserByOfficeId(String officeId) {
		// TODO Auto-generated method stub
		return systemService.findUserByOfficeId(officeId);
	}*/

	@Override
	public Collection<Session> getActiveSessions(boolean b, Principal principal, Session session) {
		// TODO Auto-generated method stub
		return systemService.getSessionDao().getActiveSessions(b,principal,session);
	}

	@Transactional(readOnly = false)
	@Override
	public void delete(Session session) {
		// TODO Auto-generated method stub
		systemService.getSessionDao().delete(session);
	}

	@Override
	public Collection<Session> getActiveSessions(boolean b) {
		// TODO Auto-generated method stub
		return systemService.getSessionDao().getActiveSessions(b);
	}

	@Transactional(readOnly = false)
	@Override
	public void updateUserLoginInfo(User user) {
		// TODO Auto-generated method stub
		systemService.updateUserLoginInfo(user);
	}

}
