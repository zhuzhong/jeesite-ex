/**
 * 
 */
package com.thinkgem.jeesite.modules.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.modules.sys.dao.RoleDao;
import com.thinkgem.jeesite.modules.sys.entity.Role;
import com.thinkgem.jeesite.modules.sys.service.IRoleService;

/**
 * @author sunff
 *
 */
@Service
@Transactional(readOnly = true)
public class RoleService implements IRoleService {
	
	
	@Autowired
	private RoleDao roleDao;

	@Override
	public List<Role> findList(Role role) {
		// TODO Auto-generated method stub
		return roleDao.findList(role);
	}

	@Override
	public List<Role> findAllList(Role role) {
		// TODO Auto-generated method stub
		return roleDao.findAllList(role);
	}

}
