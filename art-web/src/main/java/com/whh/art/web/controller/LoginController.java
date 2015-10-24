package com.whh.art.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whh.art.dao.model.AdminModel;
import com.whh.art.dao.model.ArtModel;
import com.whh.art.dao.model.MuseumModel;
import com.whh.art.service.IAdminService;
import com.whh.art.service.IArtService;
import com.whh.art.web.form.MuseumForm;
import com.whh.art.web.form.Result;

@Controller
public class LoginController {

	public static String SESSION_KEY = "__session_user__";

	@Resource
	IAdminService adminService;
	@Resource
	IArtService artService;

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
	public String index(HttpSession session,ModelMap model) {
		
		List<MuseumForm> museumList = new ArrayList<MuseumForm>();
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
		
		model.addAttribute("museums", museumList);
		
		
		return "home";
	}

}
