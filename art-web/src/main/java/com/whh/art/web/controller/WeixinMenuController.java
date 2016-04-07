package com.whh.art.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.whh.art.dao.model.WeixinMenuModel;
import com.whh.art.service.IWeixinService;

@Controller
public class WeixinMenuController {

	@Resource
	IWeixinService weixinService;
	
	@RequestMapping(value = "admin/weixin/menu/view", method = { RequestMethod.GET })
	public String viewArtAdd(HttpSession session,ModelMap model) {
		List<WeixinMenuModel> tree = weixinService.loadWeixinMenus();
		
		model.put("menus", tree);
		
		model.put("localJson", weixinService.weixinMenuJsonBuilder(tree));
		
		model.put("remoteJson", weixinService.getWeixinMenuFromMP());
		
		return "weixin/menu_list";
	}
}
