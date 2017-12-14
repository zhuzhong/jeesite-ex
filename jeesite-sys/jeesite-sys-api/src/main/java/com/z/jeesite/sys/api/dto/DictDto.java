/**
 * 
 */
package com.z.jeesite.sys.api.dto;

import java.io.Serializable;

/**
 * @author sunff
 *
 */
public class DictDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3066024481183510089L;
	private String value; // 数据值
	private String label; // 标签名
	private String type; // 类型

	private Integer sort; // 排序

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

}
