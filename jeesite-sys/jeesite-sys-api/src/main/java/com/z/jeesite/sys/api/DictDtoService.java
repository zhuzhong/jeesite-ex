/**
 * 
 */
package com.z.jeesite.sys.api;

import java.util.List;

import com.z.jeesite.sys.api.dto.DictDto;

/**提供数据字典服务
 * @author sunff
 *
 */
public interface DictDtoService {

	
	
	List<DictDto> getDictListByType(String type);
}
