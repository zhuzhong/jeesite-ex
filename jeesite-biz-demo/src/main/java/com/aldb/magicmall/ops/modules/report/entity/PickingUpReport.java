/**
 * 
 */
package com.aldb.magicmall.ops.modules.report.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author sunff
 *
 */
public class PickingUpReport {

	private Date purchaseDate;// 采购日期，yyyy-mm-dd

	private Long orderId;
	private String orderNo;

	private String sellerCode; // 卖家 code
	private String sellerName;

	private String sellerOrderId;// 外部供应商的id

	private BigDecimal purchasePrice;// 采购金额

	private String orderState;
	
	
	

}
