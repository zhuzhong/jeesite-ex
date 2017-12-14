/**
 * 
 */
package com.thinkgem.jeesite.dict.srv.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.thinkgem.jeesite.modules.sys.entity.Dict;
import com.thinkgem.jeesite.modules.sys.utils.DictUtils;
import com.z.jeesite.sys.api.DictDtoService;
import com.z.jeesite.sys.api.dto.DictDto;

/**
 * @author sunff
 *
 */
@Service
public class DictDtoServiceImpl implements DictDtoService {

	@Override
	public List<DictDto> getDictListByType(String type) {
		List<Dict> dicts = DictUtils.getDictList(type);

		if (dicts == null) {
			return null;
		}

		List<DictDto> list = new ArrayList<DictDto>();
		for (Dict dict : dicts) {
			DictDto d = new DictDto();
			d.setLabel(dict.getLabel());
			d.setSort(dict.getSort());
			d.setType(dict.getType());
			d.setValue(dict.getValue());
			list.add(d);
		}
		return list;
	}

}
