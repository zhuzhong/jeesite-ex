package com.thinkgem.jeesite.modules.sys.api;

import java.util.List;

import com.thinkgem.jeesite.modules.sys.entity.Office;

public interface IOfficeService {

	List<Office> findAllList(Office office);

	List<Office> findList(Office office);

	Office get(String id);

	List<Office> findAll();

	void save(Office office);

	void delete(Office office);

	List<Office> findList(Boolean isAll);

}
