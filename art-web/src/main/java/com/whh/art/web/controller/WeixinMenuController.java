package com.whh.art.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whh.art.dao.model.WeixinMenuModel;
import com.whh.art.service.IWeixinService;
import com.whh.art.web.form.Result;

@Controller
public class WeixinMenuController {

	@Resource
	IWeixinService weixinService;

	@RequestMapping(value = "admin/weixin/menu/view", method = { RequestMethod.GET })
	public String viewMenus(HttpSession session, ModelMap model) {
		List<WeixinMenuModel> tree = weixinService.loadWeixinMenus();

		WeixinMenuModel blank = new WeixinMenuModel();
		tree.add(blank);

		model.put("menus", tree);

		model.put("localJson", weixinService.weixinMenuJsonBuilder(tree));

		model.put("remoteJson", weixinService.getWeixinMenuFromMP());

		return "weixin/menu_list";
	}

	@RequestMapping(value = "admin/weixin/menu/add", method = { RequestMethod.GET })
	public String subMenuAddView(
			@RequestParam(value = "pid", required = false, defaultValue = "0") int pid,
			ModelMap model) {
		// 添加二级菜单
		model.put("pid", pid);
		return "weixin/menu_add";
	}

	@RequestMapping(value = "admin/weixin/menu/save", method = { RequestMethod.POST })
	public @ResponseBody
	Result menuSave(@RequestParam("pid") int pid,
			@RequestParam("name") String name,
			@RequestParam("type") String type,
			@RequestParam("param") String param, ModelMap model) {

		WeixinMenuModel root = weixinService.getWeixinMenuFromDB(pid);
		if (root == null) {
			pid = 0;
		}

		WeixinMenuModel button = new WeixinMenuModel();

		button.setName(name);
		button.setType(type);
		if (type.equals("media_id") || type.equals("view_limited")) {
			button.setMedia_id(param);
		} else if (type.equals("view")) {
			button.setUrl(param);
		} else {
			button.setKey(param);
		}

		button.setPid(pid);

		weixinService.addWeixinMenu2DB(button);

		return new Result(null);
	}
	
	
	/**
	 * 删除数据库的菜单
	 * 
	 * @return
	 */
	@RequestMapping(value = "admin/weixin/menu/delete", method = { RequestMethod.GET })
	public @ResponseBody
	Result deleteWxMenu(@RequestParam("id") int id) {

		weixinService.deleteWeixinMenuFromDB(id);

		return new Result(null);
	}

	/**
	 * 把菜单刷新到微信
	 * 
	 * @return
	 */
	@RequestMapping(value = "admin/weixin/menu/flush", method = { RequestMethod.GET })
	public @ResponseBody
	Result flush2Wx() {
		List<WeixinMenuModel> tree = weixinService.loadWeixinMenus();

		weixinService.createWeixinMenu2MP(tree);

		return new Result(null);
	}

	/**
	 * 清空微信菜单
	 * 
	 * @return
	 */
	@RequestMapping(value = "admin/weixin/menu/clear", method = { RequestMethod.GET })
	public @ResponseBody
	Result clearWxMenu() {

		weixinService.deleteWeixinMenuFromMP();

		return new Result(null);
	}
}
