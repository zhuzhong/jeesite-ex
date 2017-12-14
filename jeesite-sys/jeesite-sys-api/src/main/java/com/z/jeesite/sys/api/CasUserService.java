/**
 * 
 */
package com.z.jeesite.sys.api;

import com.z.jeesite.sys.api.dto.CasUser;

/**
 * @author zhuzhong
 *
 */
public interface CasUserService {

	
	
	CasUser getUserByLoginName(String loginName);
}
