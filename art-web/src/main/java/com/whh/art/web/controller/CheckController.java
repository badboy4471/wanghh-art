package com.whh.art.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whh.art.dao.model.AdminModel;
import com.whh.art.dao.model.ArtModel;
import com.whh.art.dao.model.ReceiptModel;
import com.whh.art.dao.model.ReceiptModel.ReceiptStatus;
import com.whh.art.dao.model.ReceiptModel.ReceiptType;
import com.whh.art.service.ICheckService;
import com.whh.art.utils.ArtErrorCode;
import com.whh.art.web.form.ArtSubmit;
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
		int uid = ((AdminModel) session.getAttribute(LoginController.SESSION_KEY)).getId();
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
	
	
	@RequestMapping(value = "admin/check/detail/save", method = { RequestMethod.POST })
	public @ResponseBody
	Result saveArt(@ModelAttribute ArtSubmit artSubmit, HttpSession session) {
		Result result = new Result(null);
		ArtModel model = new ArtModel();
		BeanUtils.copyProperties(artSubmit, model);
		System.out.println(artSubmit);
		if (artSubmit.getId() > 0){ //编辑
			
			return result;
		}else{
			try{
				
			}catch(Exception e){
				result.setCode(ArtErrorCode.SYSTEM_ERROR.getCode());
				result.setMessage(ArtErrorCode.SYSTEM_ERROR.getMessage());
			}
			return result;
		}
	}
}
