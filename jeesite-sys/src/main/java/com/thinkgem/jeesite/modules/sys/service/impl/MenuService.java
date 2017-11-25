/**
 * 
 */
package com.thinkgem.jeesite.modules.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.modules.sys.dao.MenuDao;
import com.thinkgem.jeesite.modules.sys.entity.Menu;
import com.thinkgem.jeesite.modules.sys.service.IMenuService;

/**
 * @author sunff
 *
 */
@Service
@Transactional(readOnly = true)
public class MenuService implements IMenuService{

	@Autowired
	private MenuDao menuDao;
	@Override
	public List<Menu> findAllList(Menu menu) {

		return menuDao.findAllList(menu);
	}

	@Override
	public List<Menu> findByUserId(Menu m) {

		return menuDao.findByUserId(m);
	}

}
