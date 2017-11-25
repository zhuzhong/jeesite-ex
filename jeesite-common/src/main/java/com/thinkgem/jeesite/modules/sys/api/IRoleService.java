package com.thinkgem.jeesite.modules.sys.api;

import java.util.List;

import com.thinkgem.jeesite.modules.sys.entity.Role;

public interface IRoleService {

	List<Role> findList(Role role);

	List<Role> findAllList(Role role);

}
