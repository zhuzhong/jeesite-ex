package com.thinkgem.jeesite.modules.sys.api;

import java.util.List;

import com.thinkgem.jeesite.modules.sys.entity.Menu;

public interface IMenuService {

	List<Menu> findAllList(Menu menu);

	List<Menu> findByUserId(Menu m);

}
