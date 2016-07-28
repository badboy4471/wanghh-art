package com.whh.art.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
import com.whh.art.dao.model.ArtModel;
import com.whh.art.dao.model.ArtOutModel;
import com.whh.art.dao.model.CheckDetailModel;
import com.whh.art.dao.model.ReceiptModel;
import com.whh.art.dao.model.SearchModel;
import com.whh.art.service.IArtService;
import com.whh.art.service.ICheckService;
import com.whh.art.service.IOptLogService;
import com.whh.art.utils.ArtErrorCode;
import com.whh.art.utils.ArtUtils;
import com.whh.art.web.form.ArtSubmit;
import com.whh.art.web.form.JSONParam;
import com.whh.art.web.form.Result;

@Controller
public class ArtController extends BaseController {

	@Resource
	IArtService artService;
	@Resource
	IOptLogService optLogService;
	@Resource
	ICheckService checkService;

	@RequestMapping(value = "admin/art/add", method = { RequestMethod.GET })
	public String viewArtAdd(
			HttpSession session,
			ModelMap model,
			@RequestParam(value = "receiptId", required = false, defaultValue = "0") int receiptId) {
		AdminModel user = (AdminModel) session
				.getAttribute(LoginController.SESSION_KEY);
	
		SearchModel search = new SearchModel();
		search.setLimit(0);
		search.setStatus(0);//等待提交审核
		List<ReceiptModel> receipts = checkService.loadMyReceipt(user.getId(), search);
		
		if (receipts == null || receipts.size() == 0){
			return "404";
		}
		
		model.put("receipts", receipts);
		model.put("receiptId", receiptId);
		
		return "add_art";
	}

	@RequestMapping(value = "admin/art/list", method = { RequestMethod.GET })
	public String viewArtList() {
		return "art_list";
	}

	@RequestMapping(value = {"admin/art/detail","art/detail"}, method = { RequestMethod.GET })
	public String viewArtDetail(@RequestParam("id") int id, ModelMap model,HttpServletRequest request) {

		ArtModel art = artService.getArt(id);

		model.addAttribute("art", art);
		
		if (request.getRequestURI().indexOf("admin")>=0){
			return "dialog/art_detail";
		}else{
			return "art_detail";
		}
	}
	
	@RequestMapping(value = {"admin/art/edit"}, method = { RequestMethod.GET })
	public String viewArtEdit(@RequestParam("id") int id, ModelMap model,HttpServletRequest request) {

		ArtModel art = artService.getArt(id);

		model.addAttribute("art", art);
		
		return "add_art";
	}

	@RequestMapping(value = "admin/art/out", method = { RequestMethod.GET })
	public String viewArtOutPage(@RequestParam("artId") int artId,
			HttpSession session, ModelMap map) {
		
		ArtModel art = artService.getArt(artId);
		map.addAttribute("art", art);
		return "art_out";
	}

	@RequestMapping(value = "admin/art/del", method = { RequestMethod.GET })
	public @ResponseBody
	Result delArt(@RequestParam("id") int id, ModelMap model) {
		Result result = new Result(null);
		ArtModel art = artService.getArt(id);

		if (art != null) {
			artService.delArt(id);
		} else {
			result.setCode(2404);
		}
		model.addAttribute("art", art);
		return result;
	}

	@RequestMapping(value = "admin/art/search", method = { RequestMethod.POST,
			RequestMethod.GET }, produces = "application/json")
	public @ResponseBody
	Result loadArts(@RequestBody JSONParam[] params, HttpSession session) {

		Map paramMap = new HashMap();
		super.convert2Map(paramMap, params);
		Result result = new Result(null);
		SearchModel search = new SearchModel();
		search.setName((String) paramMap.get("name"));
		search.setNumber((String) paramMap.get("number"));
		String innerNumber = (String) paramMap.get("innerNumber");
		search.setInnerNumber(innerNumber);
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
		List<ArtModel> arts = artService.searchArts(search);
		int count = artService.countArts(search);
		result.setAaData(arts);
		result.setsEcho((String) paramMap.get("sEcho"));
		result.setiTotalRecords(count);
		result.setiTotalDisplayRecords(count);
		return result;
	}

	@RequestMapping(value = "admin/art/save", method = { RequestMethod.POST })
	public @ResponseBody
	Result saveArt(@ModelAttribute ArtSubmit artSubmit, HttpSession session) {
		Result result = new Result(null);
		ArtModel model = new ArtModel();
		BeanUtils.copyProperties(artSubmit, model);
		if (artSubmit.getId() > 0){ //编辑
			ArtModel art = artService.getArt(artSubmit.getArtNumber());
			if (art != null && art.getId() != artSubmit.getId()) {
				result.setCode(ArtErrorCode.DUPLICATE.getCode());
				result.setMessage(ArtErrorCode.DUPLICATE.getMessage());
				return result;
			}
			try{
				artService.updateArt(model);
				result.setCode(200);
			}catch(Exception e){
				result.setCode(ArtErrorCode.SYSTEM_ERROR.getCode());
				result.setMessage(ArtErrorCode.SYSTEM_ERROR.getMessage());
			}
			return result;
		}else{
			try{
				ArtModel art = artService.insertArt(model);
				if (art.getId() > 0) {
					result.setCode(200);
				} else {
					result.setCode(ArtErrorCode.SYSTEM_ERROR.getCode());
					result.setMessage(ArtErrorCode.SYSTEM_ERROR.getMessage());
				}
			}catch(Exception e){
				result.setCode(ArtErrorCode.SYSTEM_ERROR.getCode());
				result.setMessage(ArtErrorCode.SYSTEM_ERROR.getMessage());
			}
			return result;
		}
	}
	
	@RequestMapping(value = "admin/art/out/save", method = { RequestMethod.POST })
	public @ResponseBody
	Result saveArtOut(@RequestParam("memo") String memo,
			@RequestParam("outType") String outType,
			@RequestParam("returnTime") String returnTime,
			@RequestParam("artId")int artId) {
		Result result = new Result(null);
		
		ArtModel art = artService.getArt(artId);
		if (art == null || art.getId() == 0){
			result.setCode(0);
			result.setMessage("参数不对，artId="+artId+"对应的数据不存在！");
			return result;
		}
		
		ArtOutModel out = new ArtOutModel();
		
		out.setArt(art);
		if (StringUtils.isNotBlank(returnTime)){
			out.setBackTime(ArtUtils.getDate(returnTime));
		}
		out.setType(outType);
		optLogService.insertArtOut(out);
		result.setCode(200);
		result.setMessage("保存成功！");
		return result;
	}

	@RequestMapping(value = "admin/art/number/valid", method = {
			RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	boolean validArtNumber(@RequestParam("artNumber") String artNumber,
			@RequestParam("id") String idStr, HttpSession session) {
		int id = 0;
		if (StringUtils.isNotBlank(idStr)) {
			try {
				id = Integer.parseInt(idStr);
			} catch (Exception e) {
			}
		}
		ArtModel art = artService.getArt(artNumber);

		if (art == null) {
			
			CheckDetailModel model = checkService.getCheckDetail(artNumber);
			if (model == null){
				return true;
			}else{
				if (model.getId() != id) {
					return false;
				} else {
					return true;
				}
			}
		} else {
			if (art.getId() != id) {
				return false;
			} else {
				return true;
			}
		}
	}

}
