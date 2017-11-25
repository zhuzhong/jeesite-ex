package com.thinkgem.jeesite.modules.sys.api;

import java.util.List;

import com.thinkgem.jeesite.modules.sys.entity.Area;

public interface IAreaService {

	List<Area> findAllList(Area area);

	Area get(String id);

	List<Area> findAll();

	void save(Area area);

	void delete(Area area);

}
