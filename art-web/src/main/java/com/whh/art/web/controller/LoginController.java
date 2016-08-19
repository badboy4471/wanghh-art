package com.whh.art.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whh.art.dao.model.AdminModel;
import com.whh.art.dao.model.ArtModel;
import com.whh.art.dao.model.MuseumModel;
import com.whh.art.dao.model.ReceiptModel;
import com.whh.art.dao.model.SearchModel;
import com.whh.art.dao.model.SystemActionModel;
import com.whh.art.service.IAdminService;
import com.whh.art.service.IArtService;
import com.whh.art.service.ICheckService;
import com.whh.art.web.form.MuseumForm;
import com.whh.art.web.form.Result;

@Controller
public class LoginController {

	public static String SESSION_KEY = "__session_user__";
	public static String USER_RIGHT_KEY = "__user_right_key__";

	@Resource
	IAdminService adminService;
	@Resource
	IArtService artService;
	@Resource 
	ICheckService checkService;

	@RequestMapping(value = "login", method = { RequestMethod.POST,
			RequestMethod.GET }, produces = "application/json")
	public @ResponseBody
	Result login(@RequestParam("userName") String userName,
			@RequestParam("password") String password, HttpServletRequest request) {
		Result result = new Result(null);

		AdminModel admin = adminService.login(userName, password);

		if (admin != null) {
			result.setData(admin);
			request.getSession().setAttribute(SESSION_KEY, admin);
			Set<SystemActionModel> actions = adminService.loadSystemActions(admin.getId());
			request.getSession().setAttribute(USER_RIGHT_KEY, actions);

		} else {
			result.setCode(404);
			result.setMessage("登陆失败！");
		}
		return result;
	}

	@RequestMapping(value = "admin/index", method = { RequestMethod.GET })
	public String index(HttpSession session,ModelMap model) {
		int uid = ((AdminModel) session.getAttribute(LoginController.SESSION_KEY)).getId();
		
		//我发起的审核单
		SearchModel search = new SearchModel();
		search.setLimit(3);
		search.setStatus(null);
		List<ReceiptModel> receipts = checkService.loadMyReceipt(uid, search);
		
		model.put("receipts", receipts);
		
		//需要我审核的审核单
		search.setStatus(0);
		search.setStart(0);
		search.setLimit(3);//全部取出
		List<ReceiptModel> myReceipts = this.checkService.loadMyCheckReceipts(uid, search);
		model.put("myReceipts", myReceipts);
		
		
		/*List<MuseumForm> museumList = new ArrayList<MuseumForm>();
		List<MuseumModel> museums = artService.loadAllMuseum();
		
		for (MuseumModel museum : museums){
			MuseumForm form = new MuseumForm();
			List<ArtModel> arts = artService.loadArtsFromMueum(museum.getId(), 0, 3);
			form.setArts(arts);
			int count = artService.countArtsFromMueum(museum.getId());
			form.setArtCount(count);
			form.setMuseum(museum);
			museumList.add(form);
		}
		//添加按钮
		MuseumForm form = new MuseumForm();
		museumList.add(form);
		
		model.addAttribute("museums", museumList);*/
		
		
		return "home";
	}
	
	
	@RequestMapping(value = "admin/to/change/password", method = { RequestMethod.GET })
	public String viewChangePassword(HttpSession session,ModelMap model) {
		return "dialog/password";
	}
	
	
	@RequestMapping(value = "admin/change/password", method = { RequestMethod.POST,
			RequestMethod.GET }, produces = "application/json")
	public @ResponseBody
	Result changePassword(@RequestParam("oldPassword") String oldPassword,
			@RequestParam("newPassword2") String newPassword2,
			@RequestParam("newPassword") String newPassword, HttpServletRequest request) {
		Result result = new Result(null);

		AdminModel admin = (AdminModel)request.getSession().getAttribute(SESSION_KEY);
		if (newPassword.trim().equals(newPassword2.trim())){
			if (admin.getPassword().equals(oldPassword)){
				admin.setPassword(newPassword);
				adminService.updateAdmin(admin);
				
				request.getSession().removeAttribute(SESSION_KEY);
				result.setMessage("修改成功，请重新登录！");
				result.setCode(200);
			}else{
				result.setCode(404);
				result.setMessage("旧密码不对！");
			}
		}else{
			result.setCode(404);
			result.setMessage("两次新密码不一致！");
		}
		
		return result;
	}
	
	
	@RequestMapping(value = "admin/logout", method = { RequestMethod.GET })
	public void logout(HttpSession session,ModelMap model,HttpServletResponse response,HttpServletRequest request) {
		session.removeAttribute(SESSION_KEY);
		try {
			String path = request.getContextPath()+"/login.html";
			response.sendRedirect(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
