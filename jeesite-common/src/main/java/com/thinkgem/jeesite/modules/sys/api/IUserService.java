package com.thinkgem.jeesite.modules.sys.api;

import com.thinkgem.jeesite.modules.sys.entity.User;

public interface IUserService {

	User get(String id);

	User getByLoginName(User user);

}
