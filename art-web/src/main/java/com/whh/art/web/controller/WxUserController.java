package com.whh.art.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whh.art.dao.model.SearchModel;
import com.whh.art.dao.model.WxUserModel;
import com.whh.art.service.IAdminService;
import com.whh.art.web.form.JSONParam;
import com.whh.art.web.form.Result;

@Controller
public class WxUserController extends BaseController {
	
	@Resource
	IAdminService adminService;
	
	@RequestMapping(value = "admin/wx/user/list", method = { RequestMethod.GET })
	public String viewArtList() {
		return "user/list";
	}
	
	
	@RequestMapping(value = "admin/wx/user/search", method = { RequestMethod.POST,
			RequestMethod.GET }, produces = "application/json")
	public @ResponseBody
	Result loadArts(@RequestBody JSONParam[] params, HttpSession session) {

		Map paramMap = new HashMap();
		super.convert2Map(paramMap, params);
		Result result = new Result(null);
		SearchModel search = new SearchModel();
		search.setName((String) paramMap.get("name"));
		search.setNumber((String) paramMap.get("number"));

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
		
		
		int count = adminService.countUsers(search);
		List<WxUserModel> users = adminService.loadUsers(search);
		
		result.setAaData(users);
		result.setsEcho((String) paramMap.get("sEcho"));
		result.setiTotalRecords(count);
		result.setiTotalDisplayRecords(count);
		return result;
	}

}
