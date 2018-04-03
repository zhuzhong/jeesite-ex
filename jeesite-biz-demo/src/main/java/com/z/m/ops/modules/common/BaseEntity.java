/**
 * 
 */
package com.z.m.ops.modules.common;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thinkgem.jeesite.common.persistence.Page;

/**
 * @author zhuzhong
 *
 */
public class BaseEntity<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 839815120166169610L;
	/**
	 * 当前实体分页对象
	 */
	protected Page<T> page;

	@JsonIgnore
	@XmlTransient
	public Page<T> getPage() {
		if (page == null) {
			page = new Page<T>();
		}
		return page;
	}

	public Page<T> setPage(Page<T> page) {
		this.page = page;
		return page;
	}
}
