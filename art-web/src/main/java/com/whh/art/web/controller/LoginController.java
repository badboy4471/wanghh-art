package com.whh.art.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whh.art.dao.model.AdminModel;
import com.whh.art.service.IAdminService;
import com.whh.art.web.form.Result;

@Controller
public class LoginController {

	public static String SESSION_KEY = "__session_user__";

	@Resource
	IAdminService adminService;

	@RequestMapping(value = "login", method = { RequestMethod.POST,
			RequestMethod.GET }, produces = "application/json")
	public @ResponseBody
	Result login(@RequestParam("userName") String userName,
			@RequestParam("password") String password, HttpSession session) {
		Result result = new Result(null);

		AdminModel admin = adminService.login(userName, password);

		if (admin != null) {
			result.setData(admin);

			session.setAttribute(SESSION_KEY, admin);

		} else {
			result.setCode(404);
			result.setMessage("登陆失败！");
		}
		return result;
	}

	@RequestMapping(value = "admin/index", method = { RequestMethod.GET })
	public String index(HttpSession session) {
		return "home";
	}

}
