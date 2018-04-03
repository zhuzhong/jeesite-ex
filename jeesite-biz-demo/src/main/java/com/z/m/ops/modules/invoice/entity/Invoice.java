/**
 * 
 */
package com.z.m.ops.modules.invoice.entity;

import java.util.Date;

import com.z.m.ops.modules.common.BaseEntity;

/**
 * @author zhuzhong
 *
 */
public class Invoice extends BaseEntity<Invoice> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6326811055414341521L;
	private Long id;
	private Long orderId;// 订单id
	private Long customerId; // 用户id
	private Long invoiceType; // 开票类型，这个是否需要改为string
	private String invoiceTitle; // 开票抬头
	private String invoiceContent;// 开票内容
	private Integer state;// 开票业务状态

	private Long receProvince, receCity, receCounty, receTown;
	private String receAddress, receFullAddress;

	private Date updatedAt;
	private String updatedBy;
	private Date createdAt;
	private String createdBy;

	private String remark; // 备注
	private Integer deleteFlag; // 删除标识

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(Long invoiceType) {
		this.invoiceType = invoiceType;
	}

	public String getInvoiceTitle() {
		return invoiceTitle;
	}

	public void setInvoiceTitle(String invoiceTitle) {
		this.invoiceTitle = invoiceTitle;
	}

	public String getInvoiceContent() {
		return invoiceContent;
	}

	public void setInvoiceContent(String invoiceContent) {
		this.invoiceContent = invoiceContent;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Long getReceProvince() {
		return receProvince;
	}

	public void setReceProvince(Long receProvince) {
		this.receProvince = receProvince;
	}

	public Long getReceCity() {
		return receCity;
	}

	public void setReceCity(Long receCity) {
		this.receCity = receCity;
	}

	public Long getReceCounty() {
		return receCounty;
	}

	public void setReceCounty(Long receCounty) {
		this.receCounty = receCounty;
	}

	public Long getReceTown() {
		return receTown;
	}

	public void setReceTown(Long receTown) {
		this.receTown = receTown;
	}

	public String getReceAddress() {
		return receAddress;
	}

	public void setReceAddress(String receAddress) {
		this.receAddress = receAddress;
	}

	public String getReceFullAddress() {
		return receFullAddress;
	}

	public void setReceFullAddress(String receFullAddress) {
		this.receFullAddress = receFullAddress;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	// 查询条件
	private Date beginCreatedAt, endCreatedAt;

	public Date getBeginCreatedAt() {
		return beginCreatedAt;
	}

	public void setBeginCreatedAt(Date beginCreatedAt) {
		this.beginCreatedAt = beginCreatedAt;
	}

	public Date getEndCreatedAt() {
		return endCreatedAt;
	}

	public void setEndCreatedAt(Date endCreatedAt) {
		this.endCreatedAt = endCreatedAt;
	}

}
