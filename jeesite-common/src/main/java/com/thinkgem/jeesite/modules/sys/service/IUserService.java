package com.thinkgem.jeesite.modules.sys.service;

import com.thinkgem.jeesite.modules.sys.entity.User;

public interface IUserService {

	User get(String id);

	User getByLoginName(User user);

}
