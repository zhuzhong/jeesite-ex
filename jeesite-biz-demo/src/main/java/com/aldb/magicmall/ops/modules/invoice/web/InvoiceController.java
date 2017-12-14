/**
 * 
 */
package com.aldb.magicmall.ops.modules.invoice.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aldb.magicmall.ops.modules.invoice.entity.Invoice;
import com.aldb.magicmall.ops.modules.invoice.srv.InvoiceService;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;

/**
 * @author zhuzhong
 *
 */
@Controller
@RequestMapping(value = "${adminPath}/invoice/invoice")
public class InvoiceController extends BaseController {

	@Autowired
	private InvoiceService invoiceService;

	@ModelAttribute
	public Invoice get(@RequestParam(required = false) Long id) {
		Invoice entity = null;
		if (id != null) {
			entity = invoiceService.get(id);
		}
		if (entity == null) {
			entity = new Invoice();
		}
		return entity;
	}

	@RequiresPermissions("invoice:invoice:view")
	@RequestMapping(value = { "list", "" })
	public String list(Invoice invoice, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Invoice> page = invoiceService.findPage(new Page<Invoice>(request, response), invoice);
		model.addAttribute("page", page);
		return "modules/invoice/invoiceList";
	}

	@RequiresPermissions("invoice:invoice:view")
	@RequestMapping(value = "form")
	public String form(Invoice invoice, Model model) {
		model.addAttribute("invoice", invoice);
		return "modules/invoice/invoiceForm";
	}

	
	
	//新增
	@RequiresPermissions("invoice:invoice:edit")
	@RequestMapping(value = "save")
	public String save(Invoice invoice, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, invoice)) {
			return form(invoice, model);
		}
		invoiceService.save(invoice);
		addMessage(redirectAttributes, "保存成功");
		return String.format("redirect:%s/invoice/invoice/?repage", Global.getAdminPath());
	}

	
	//删除
	@RequiresPermissions("invoice:invoice:edit")
	@RequestMapping(value = "delete")
	public String delete(Invoice invoice, RedirectAttributes redirectAttributes) {
		invoiceService.delete(invoice);
		addMessage(redirectAttributes, "删除成功");
		return String.format("redirect:%s/invoice/invoice/?repage", Global.getAdminPath());
	}
}
