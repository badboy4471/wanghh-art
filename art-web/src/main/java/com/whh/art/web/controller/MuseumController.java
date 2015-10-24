package com.whh.art.web.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whh.art.dao.model.MuseumModel;
import com.whh.art.service.IArtService;
import com.whh.art.web.form.Result;

@Controller
public class MuseumController {

	@Resource
	IArtService artService;

	@RequestMapping(value = "admin/museum/add", method = { RequestMethod.GET })
	public String viewArtAdd(HttpSession session) {
		return "dialog/museum_add";
	}

	@RequestMapping(value = "admin/museum/list", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String showMuseum(HttpSession session,
			@RequestParam("artId") int artId, ModelMap map) {
		List<MuseumModel> museums = artService.loadAllMuseum();
		int mod = museums.size() % 3;
		for (int i = mod;i<3;i++){
			MuseumModel model = new MuseumModel();
			museums.add(model);
		}
		map.put("museums", museums);
		map.put("artId", artId);
		return "dialog/archive";
	}

	@RequestMapping(value = "admin/art/museum/save", method = { RequestMethod.POST })
	public @ResponseBody
	Result saveArtMuseum(@RequestParam("artId") int artId,
			@RequestParam("museumId") int[] museumIds, HttpSession session) {
		Result result = new Result(null);

		// 先删除所有artId 对应的归档信息
		artService.deleteMuseumArt(0, artId);
		try {
			// 重新插入
			for (int museumId : museumIds) {
				artService.insertArt2Museum(artId, museumId);
			}
			result.setCode(200);
		} catch (Exception e) {
			result.setMessage(e.getMessage());
			result.setCode(-1);
		}
		return result;
	}

	@RequestMapping(value = "admin/museum/save", method = { RequestMethod.POST })
	public @ResponseBody
	Result saveMuseum(@RequestParam("name") String name,
			@RequestParam("location") String location, HttpSession session) {
		Result result = new Result(null);
		MuseumModel model = new MuseumModel();
		model.setName(name);
		model.setLocation(location);
		model.setCreateTime(new Date());
		try {
			artService.insertMuseum(model);
		} catch (Exception e) {
			e.printStackTrace();
			result.setMessage(e.getMessage());
		}

		if (model.getId() > 0) {
			result.setCode(200);
		} else {
			result.setCode(-1);
		}
		return result;
	}

	@RequestMapping(value = "admin/museum/delete", method = { RequestMethod.POST })
	public @ResponseBody
	Result removeMuseum(@RequestParam("museumId") int museumId,
			HttpSession session) {
		Result result = new Result(null);

		if (museumId == 0) {
			result.setCode(-1);
			result.setMessage("参数错误！params:" + museumId);
		} else {
			try {
				//删除所有对应关系
				artService.deleteMuseumArt(museumId, 0);
				artService.deletMuseum(museumId);
				result.setCode(200);
			} catch (Exception e) {
				result.setMessage(e.getMessage());
				result.setCode(-1);
			}
		}

		return result;
	}

	@RequestMapping(value = "admin/museum/all", method = { RequestMethod.GET,
			RequestMethod.POST })
	public @ResponseBody
	Result loadAllMuseums(HttpSession session) {
		Result result = new Result(null);
		List<MuseumModel> museums = artService.loadAllMuseum();
		result.setData(museums);
		return result;
	}

}
