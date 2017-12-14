/**
 * 
 */
package com.aldb.magicmall.ops.modules.invoice.srv.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aldb.magicmall.ops.modules.invoice.dao.InVoiceDao;
import com.aldb.magicmall.ops.modules.invoice.entity.Invoice;
import com.aldb.magicmall.ops.modules.invoice.srv.InvoiceService;
import com.thinkgem.jeesite.common.persistence.Page;

/**
 * @author zhuzhong
 *
 */
@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	private InVoiceDao invoiceDao;

	@Override
	public Invoice get(Long id) {

		return invoiceDao.get(id);
	}

	@Override
	public Page<Invoice> findPage(Page<Invoice> page, Invoice invoice) {

		invoice.setPage(page);
		page.setList(invoiceDao.findList(invoice));
		return page;
		
	
	}

	@Override
	public void save(Invoice invoice) {
		invoiceDao.add(invoice);
	}

	@Override
	public void delete(Invoice invoice) {
		Long id = invoice.getId();
		invoiceDao.del(id);
	}

}
