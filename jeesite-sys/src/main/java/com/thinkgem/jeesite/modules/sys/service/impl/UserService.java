/**
 * 
 */
package com.thinkgem.jeesite.modules.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.modules.sys.api.IUserService;
import com.thinkgem.jeesite.modules.sys.dao.UserDao;
import com.thinkgem.jeesite.modules.sys.entity.User;

/**
 * @author sunff
 *
 */
@Service
@Transactional(readOnly = true)
public class UserService implements IUserService{

	
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public User get(String id) {
		// TODO Auto-generated method stub
		return userDao.get(id);
	}

	@Override
	public User getByLoginName(User user) {
		// TODO Auto-generated method stub
		return userDao.getByLoginName(user);
	}

}
