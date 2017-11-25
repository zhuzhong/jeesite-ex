package com.thinkgem.jeesite.modules.sys.api;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.sys.entity.Log;

public interface ILogService {

	void insert(Log log);

	Page<Log> findPage(Page<Log> page, Log log);

}
