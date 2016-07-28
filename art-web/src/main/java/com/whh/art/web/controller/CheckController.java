package com.whh.art.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whh.art.dao.model.AdminModel;
import com.whh.art.dao.model.ArtModel;
import com.whh.art.dao.model.CheckDetailModel;
import com.whh.art.dao.model.ReceiptModel;
import com.whh.art.dao.model.SearchModel;
import com.whh.art.dao.model.ReceiptModel.ReceiptStatus;
import com.whh.art.dao.model.ReceiptModel.ReceiptType;
import com.whh.art.service.ICheckService;
import com.whh.art.utils.ArtErrorCode;
import com.whh.art.web.form.ArtSubmit;
import com.whh.art.web.form.JSONParam;
import com.whh.art.web.form.ReceiptSubmit;
import com.whh.art.web.form.Result;

@Controller
public class CheckController extends BaseController {

	@Resource
	ICheckService checkService;

	@RequestMapping(value = "admin/receipt/add", method = { RequestMethod.GET })
	public String viewReceiptAdd() {
		return "check/receipt_add";
	}
	
	@RequestMapping(value = "admin/receipt/list/view", method = { RequestMethod.GET })
	public String viewReceiptList() {
		return "check/receipt_list";
	}
	
	
	@RequestMapping(value = "admin/receipt/search", method = { RequestMethod.POST,
			RequestMethod.GET }, produces = "application/json")
	public @ResponseBody
	Result loadArts(@RequestBody JSONParam[] params, HttpSession session) {
		int uid = ((AdminModel) session.getAttribute(LoginController.SESSION_KEY)).getId();
		Map paramMap = new HashMap();
		super.convert2Map(paramMap, params);
		Result result = new Result(null);
		SearchModel search = new SearchModel();
		search.setName((String) paramMap.get("name"));
		String statusStr = (String)paramMap.get("status");
		int status = 0;
		if (StringUtils.isNotBlank(statusStr)){
			try{
				
				status = Integer.parseInt(statusStr);
			}catch(Exception e){
				
			}
		}
		
		search.setStatus(status);
		
		int start = 0;
		try {
			start = Integer.parseInt((String) paramMap.get("iDisplayStart"));
		} catch (Exception e) {

		}
		int limit = 10;
		try {
			limit = Integer.parseInt((String) paramMap.get("iDisplayLength"));
		} catch (Exception e) {

		}
		search.setStart(start);
		search.setLimit(0);//全部取出
		List<ReceiptModel> receipts = this.checkService.loadMyReceipt(uid, search);
		int count = receipts == null ?0:receipts.size();
		result.setAaData(receipts);
		result.setsEcho((String) paramMap.get("sEcho"));
		result.setiTotalRecords(count);
		result.setiTotalDisplayRecords(count);
		return result;
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
		CheckDetailModel checkDetail = new CheckDetailModel();
		BeanUtils.copyProperties(artSubmit, checkDetail);
		if (artSubmit.getId() > 0){ //编辑
			return result;
		}else{
			try{
				checkService.insertCheckDetail(checkDetail);
			}catch(Exception e){
				result.setCode(ArtErrorCode.SYSTEM_ERROR.getCode());
				result.setMessage(ArtErrorCode.SYSTEM_ERROR.getMessage());
			}
			return result;
		}
	}
}
