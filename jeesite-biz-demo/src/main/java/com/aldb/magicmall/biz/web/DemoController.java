/**
 * 
 */
package com.aldb.magicmall.biz.web;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhuzhong
 *
 */
@Controller
public class DemoController {

	/*@RequiresPermissions("mobuy:demo:view")
	@RequestMapping("/a")
	public String a() {
		return "modules/demo/session";
	}*/
}
