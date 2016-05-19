package com.whh.art.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whh.art.dao.model.ReceiptModel;
import com.whh.art.dao.model.ReceiptModel.ReceiptStatus;
import com.whh.art.dao.model.ReceiptModel.ReceiptType;
import com.whh.art.service.ICheckService;
import com.whh.art.web.form.ReceiptSubmit;
import com.whh.art.web.form.Result;

@Controller
public class CheckController extends BaseController {

	@Resource
	ICheckService checkService;

	@RequestMapping(value = "admin/receipt/add", method = { RequestMethod.GET })
	public String viewReceiptList() {
		return "check/receipt_add";
	}

	@RequestMapping(value = "admin/receipt/save", method = { RequestMethod.POST })
	public @ResponseBody
	Result saveReceipt(@ModelAttribute ReceiptSubmit receipt,
			HttpSession session) {
		int uid = (Integer) session.getAttribute(LoginController.SESSION_KEY);
		ReceiptModel model = new ReceiptModel();
		model.setCreateUid(uid);
		model.setMemo(receipt.getMemo());
		model.setType(ReceiptType.IN.getCode());
		model.setStatus(ReceiptStatus.WAIT.getCode());
		try {
			checkService.addReceipt(model);
			return new Result(null);
		} catch (Exception e) {
			return new Result(1000);
		}

	}
}
