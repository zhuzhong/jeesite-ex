/**
 * 
 */
package com.z.m.ops.modules.invoice.srv;

import com.thinkgem.jeesite.common.persistence.Page;
import com.z.m.ops.modules.invoice.entity.Invoice;

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
