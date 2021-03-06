package com.whh.art.web.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whh.art.dao.model.AdminModel;
import com.whh.art.dao.model.CheckDetailModel;
import com.whh.art.dao.model.CheckNodeModel;
import com.whh.art.dao.model.ReceiptModel;
import com.whh.art.dao.model.ReceiptModel.ReceiptStatus;
import com.whh.art.dao.model.ReceiptModel.ReceiptType;
import com.whh.art.dao.model.SearchModel;
import com.whh.art.service.IAdminService;
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
	@Resource
	IAdminService adminService;

	@RequestMapping(value = "admin/receipt/add", method = { RequestMethod.GET })
	public String viewReceiptAdd() {
		return "dialog/receipt_add";
	}
	
	@RequestMapping(value = "admin/receipt/list/view", method = { RequestMethod.GET })
	public String viewReceiptList() {
		return "check/receipt_list";
	}
	
	@RequestMapping(value = "admin/my/receipt/list/view", method = { RequestMethod.GET })
	public String viewMyCheckReceiptList() {
		return "check/my_receipt_list";
	}
	
	@RequestMapping(value = "admin/check/detail/list/view", method = { RequestMethod.GET })
	public String viewCheckDetailList(@RequestParam("receiptId") int receiptId,
			ModelMap model) {
		model.put("receiptId",receiptId);
		return "check/check_detail_list";
	}
	
	
	@RequestMapping(value = "admin/check/process/view", method = { RequestMethod.GET })
	public String viewCheckProcess(@RequestParam("receiptId") int receiptId,
			ModelMap model,HttpSession session) {
		int uid = ((AdminModel) session.getAttribute(LoginController.SESSION_KEY)).getId();
		model.put("receiptId",receiptId);
		ReceiptModel receipt = checkService.getReceipt(receiptId);
		if (receipt != null && receipt.getCreateUid() == uid){
			List<CheckNodeModel> process = checkService.showCheckProcess(receiptId);
			model.put("process", process);
		}else{
			model.put("msg","你没有权限查看该审核单！");
		}
		return "dialog/check_process";
	}
	
	
	@RequestMapping(value = "admin/check/submit/view", method = { RequestMethod.GET })
	public String viewCheckSubmit(@RequestParam("receiptId") int receiptId,
			ModelMap model) {
		
		List<AdminModel> admins = adminService.loadAllAdmin();
		model.put("receiptId", receiptId);
		model.put("admins", admins);
		return "dialog/check_submit";
	}
	
	/**
	 * 进入审核页面
	 * @param receiptId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "admin/check/view", method = { RequestMethod.GET })
	public String viewCheck(@RequestParam("receiptId") int receiptId,
			ModelMap model) {
		model.put("receiptId", receiptId);
		return "dialog/check";
	}
	
	
	@RequestMapping(value = "admin/check/do", method = { RequestMethod.POST })
	public @ResponseBody
	Result doCheck(@RequestParam("receiptId")int receiptId,
			@RequestParam("memo")String memo,
			@RequestParam("btn")String btn,
			HttpSession session) {
		int uid = ((AdminModel) session.getAttribute(LoginController.SESSION_KEY)).getId();
		Result result = new Result(null);
		if(checkService.canCheck(receiptId, uid)){
			CheckNodeModel node = checkService.getCheckNodeByUidAndReceiptId(receiptId, uid);
			if(hasPass(btn)){
				node.setStatus(1);
			}else{
				node.setStatus(2);
			}
			node.setCheckMemo(memo);
			node.setCheckTime(new Date());
			//更新当前审核状态
			checkService.updateCheckProcess(node);
			if(hasPass(btn)){
				//判断是否是最后一个人审核通过；
				if(checkService.isFinishCheckProcess(receiptId)){
					//更新整个审核单状态；
					ReceiptModel receipt = checkService.getReceipt(receiptId);
					receipt.setLastUpdateTime(new Date());
					receipt.setStatus(ReceiptModel.ReceiptStatus.PASS.getCode());
					checkService.updateReceipt(receipt);
					//入库or出库
					
					if(receipt.getType() == ReceiptModel.ReceiptType.IN.getCode()){//入库
						checkService.insertArt(receiptId);
					}
					
				}
			}else{
				//更新其他节点为无需审核，终止审核；
				List<CheckNodeModel> nodes = checkService.loadCheckProcesses(receiptId);
				for (CheckNodeModel anode : nodes){
					if (anode.getStatus() == 0){
						anode.setStatus(-1);
						anode.setCheckMemo(uid+"审核不通过");
						anode.setCheckTime(new Date());
						checkService.updateCheckProcess(anode);
					}
				}
				//更新整个审核单的状态；
				ReceiptModel receipt = checkService.getReceipt(receiptId);
				receipt.setLastUpdateTime(new Date());
				receipt.setStatus(ReceiptStatus.REJECT.getCode());
				checkService.updateReceipt(receipt);
			}
			result.setCode(200);
			result.setMessage("审核成功！");
		}else{
			result.setCode(1404);
			result.setMessage("没有审核权限");
		}
		return result;
	}
	
	
	private boolean hasPass(String btn){
		return btn.equals("pass");
	}
	
	@RequestMapping(value = "admin/check/detail/search", method = { RequestMethod.POST,
			RequestMethod.GET }, produces = "application/json")
	public @ResponseBody
	Result loadCheckDetails(@RequestBody JSONParam[] params, HttpSession session) {
		int uid = ((AdminModel) session.getAttribute(LoginController.SESSION_KEY)).getId();
		Map paramMap = new HashMap();
		super.convert2Map(paramMap, params);
		Result result = new Result(null);
		SearchModel search = new SearchModel();
		
		String statusStr = (String)paramMap.get("status");
		Integer status = null;
		if (StringUtils.isNotBlank(statusStr)){
			try{
				status = Integer.parseInt(statusStr);
			}catch(Exception e){
				
			}
		}
		
		search.setStatus(status);
		String receiptStr = (String) paramMap.get("receiptId");
		int receiptId = 0;
		if (StringUtils.isNotBlank(receiptStr)){
			try{
				receiptId = Integer.parseInt(receiptStr);
			}catch(Exception e){
				
			}
		}
		
		search.setBatchId(receiptId);
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
		search.setLimit(limit);
		List<CheckDetailModel> checkDetails = this.checkService.searchCheckdetail(search);
		int count = checkService.countCheckDetail(search);
		result.setAaData(checkDetails);
		result.setsEcho((String) paramMap.get("sEcho"));
		result.setiTotalRecords(count);
		result.setiTotalDisplayRecords(count);
		return result;
	}
	
	/**
	 * 需要我审核的审核单
	 * @param params
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "admin/my/receipt/search", method = { RequestMethod.POST,
			RequestMethod.GET }, produces = "application/json")
	public @ResponseBody
	Result loadMyCheckReceipts(@RequestBody JSONParam[] params, HttpSession session) {
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
		search.setStart(0);
		search.setLimit(0);//全部取出
		List<ReceiptModel> receipts = this.checkService.loadMyCheckReceipts(uid, search);
		int count = receipts == null ?0:receipts.size();
		result.setAaData(receipts);
		result.setsEcho((String) paramMap.get("sEcho"));
		result.setiTotalRecords(count);
		result.setiTotalDisplayRecords(count);
		return result;
	}
	
	
	@RequestMapping(value = "admin/receipt/search", method = { RequestMethod.POST,
			RequestMethod.GET }, produces = "application/json")
	public @ResponseBody
	Result loadReceipts(@RequestBody JSONParam[] params, HttpSession session) {
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
			search.setStatus(status);
		}else{
			search.setStatus(null);
		}
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
	Result saveCheckDetail(@ModelAttribute ArtSubmit artSubmit, HttpSession session) {
		Result result = new Result(null);
		int uid = ((AdminModel) session.getAttribute(LoginController.SESSION_KEY)).getId();
		CheckDetailModel checkDetail = new CheckDetailModel();
		BeanUtils.copyProperties(artSubmit, checkDetail);
		checkDetail.setCreateUid(uid);
		if (artSubmit.getId() > 0){ //编辑
			return result;
		}else{
			try{
				CheckDetailModel model = checkService.insertCheckDetail(checkDetail);
			}catch(Exception e){
				result.setCode(ArtErrorCode.SYSTEM_ERROR.getCode());
				result.setMessage(ArtErrorCode.SYSTEM_ERROR.getMessage());
			}
			return result;
		}
	}
	
	@RequestMapping(value = "admin/check/submit", method = { RequestMethod.POST })
	public @ResponseBody
	Result submitCheck(@RequestParam("checkUser") int[] checkUid,
			@RequestParam("receiptId") int receiptId,HttpSession session) {
		Result result = new Result(null);
		int uid = ((AdminModel) session.getAttribute(LoginController.SESSION_KEY)).getId();
		try{
			
			ReceiptModel receipt = checkService.getReceipt(receiptId);
			if (receipt == null || receipt.getCreateUid() != uid){
				result.setCode(404);
				result.setMessage("操作的审核单不存在！");
				return result;
			}
			if (receipt.getStatus() != ReceiptStatus.WAIT.getCode()){
				result.setCode(500);
				result.setMessage("状态不对！");
				return result;
			}
			
			checkService.submitCheck(receiptId, checkUid);
			//更新状态
			receipt.setStatus(ReceiptStatus.CHECKING.getCode());//等待审核
			receipt.setLastUpdateTime(new Date());
			checkService.updateReceipt(receipt);
			result.setCode(200);
			result.setMessage("提交成功！");
		}catch(Exception e){
			result.setCode(500);
			result.setMessage("提交失败！");
		}
		return result;
	}
}
