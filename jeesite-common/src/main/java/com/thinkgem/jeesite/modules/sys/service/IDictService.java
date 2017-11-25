package com.thinkgem.jeesite.modules.sys.service;

import java.util.List;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.modules.sys.entity.Dict;

public interface IDictService {

	List<Dict> findAllList(Dict dict);

	Dict get(String id);

	List<String> findTypeList();

	Page<Dict> findPage(Page<Dict> page, Dict dict);

	void save(Dict dict);

	void delete(Dict dict);

	List<Dict> findList(Dict dict);

}
