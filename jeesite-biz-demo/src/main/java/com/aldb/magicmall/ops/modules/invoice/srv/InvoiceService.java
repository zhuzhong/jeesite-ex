/**
 * 
 */
package com.aldb.magicmall.ops.modules.invoice.srv;

import com.aldb.magicmall.ops.modules.invoice.entity.Invoice;
import com.thinkgem.jeesite.common.persistence.Page;

/**
 * @author zhuzhong
 *
 */
public interface InvoiceService {

	Invoice get(Long id);

	Page<Invoice> findPage(Page<Invoice> page, Invoice invoice);

	void save(Invoice invoice);

	void delete(Invoice invoice);

}
