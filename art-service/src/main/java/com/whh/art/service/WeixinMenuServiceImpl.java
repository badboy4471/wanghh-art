package com.whh.art.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.executor.ReuseExecutor;

import com.alibaba.fastjson.JSON;
import com.wanghh.art.service.wx.IAccessTokenService;
import com.whh.art.dao.bean.WeixinMenuBean;
import com.whh.art.dao.mapper.WeixinMenuMapper;
import com.whh.art.dao.model.WeixinMenuModel;
import com.whh.art.dao.model.WxAccessTokenModel;

public class WeixinMenuServiceImpl implements IWeixinService {

	private final static String WX_CREATE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create";
	private final static String WX_DELETE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete";
	private final static String WX_GET_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/get";

	WeixinMenuMapper weixinMenuMapper;
	IAccessTokenService accessTokenService;

	@Override
	public void createWeixinMenu2MP(List<WeixinMenuModel> tree) {

		WxAccessTokenModel token = accessTokenService.getAccessToken();
		if (StringUtils.isNotBlank(token.getAccess_token())) {
			HttpClient httpClient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost(WX_CREATE_MENU_URL
					+ "?access_token=" + token.getAccess_token());
			try {
				httppost.setEntity(new StringEntity(this
						.weixinMenuJsonBuilder(tree)));
				HttpResponse response = httpClient.execute(httppost);
				HttpEntity entity = response.getEntity();
				String postResult = EntityUtils.toString(entity, "UTF-8");
				System.out.println(postResult);
				httppost.releaseConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deleteWeixinMenuFromMP() {
		WxAccessTokenModel token = accessTokenService.getAccessToken();
		if (StringUtils.isNotBlank(token.getAccess_token())) {
			HttpClient httpClient = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet(WX_DELETE_MENU_URL + "?access_token="
					+ token.getAccess_token());
			try {
				HttpResponse response = httpClient.execute(httpGet);
				HttpEntity entity = response.getEntity();
				String result = EntityUtils.toString(entity, "UTF-8");
				System.out.println(result);
				httpGet.releaseConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public String getWeixinMenuFromMP() {
		WxAccessTokenModel token = accessTokenService.getAccessToken();
		if (StringUtils.isNotBlank(token.getAccess_token())) {
			HttpClient httpClient = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet(WX_GET_MENU_URL + "?access_token="
					+ token.getAccess_token());
			try {
				HttpResponse response = httpClient.execute(httpGet);
				HttpEntity entity = response.getEntity();
				String result = EntityUtils.toString(entity, "UTF-8");

				httpGet.releaseConnection();
				return result;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public void addWeixinMenu2DB(WeixinMenuModel menu) {
		weixinMenuMapper.addWeixinMenu(menu);

	}

	@Override
	public List<WeixinMenuModel> loadWeixinMenus() {
		// 获取一级菜单
		List<WeixinMenuModel> roots = weixinMenuMapper.loadWeixinMenus(0);
		for (WeixinMenuModel menu : roots) {
			// 循环获取二级菜单
			List<WeixinMenuModel> sub_menus = weixinMenuMapper
					.loadWeixinMenus(menu.getId());
			menu.setSub_menu(sub_menus);
		}
		return roots;
	}

	@Override
	public void deleteWeixinMenuFromDB(int id) {
		try {
			weixinMenuMapper.deleteWeixinMenu(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public WeixinMenuModel getWeixinMenuFromDB(int id) {
		WeixinMenuModel menu = weixinMenuMapper.getWeixinMenu(id);
		return menu;
	}

	/**
	 * 组装微信菜单Json
	 * 
	 * @param tree
	 * @return
	 */
	@Override
	public String weixinMenuJsonBuilder(List<WeixinMenuModel> tree) {

		List<WeixinMenuBean> buttons = new ArrayList<WeixinMenuBean>();

		for (WeixinMenuModel model : tree) {
			// 拷贝一级菜单
			WeixinMenuBean button = new WeixinMenuBean();
			try {
				BeanUtils.copyProperties(button, model);
				// 二级菜单
				List<WeixinMenuBean> sub_buttons = new ArrayList<WeixinMenuBean>();
				if (model.getSub_menu() != null) {
					for (WeixinMenuModel sub_menu : model.getSub_menu()) {
						WeixinMenuBean sub_button = new WeixinMenuBean();
						try {
							BeanUtils.copyProperties(sub_button, sub_menu);
							sub_buttons.add(sub_button);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					button.setSub_button(sub_buttons);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			buttons.add(button);
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("button", buttons);

		try {
			return JSON.toJSONString(map);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public static void main(String[] args) {

		List<WeixinMenuModel> tree = new ArrayList<WeixinMenuModel>();

		WeixinMenuModel root1 = new WeixinMenuModel();
		root1.setKey("key1");
		root1.setType("click");
		root1.setName("菜单一");
		tree.add(root1);
		WeixinMenuModel root2 = new WeixinMenuModel();
		root2.setType("view");
		root2.setName("菜单二");
		root2.setUrl("http://www.qupai.me");

		// 二级
		List<WeixinMenuModel> subs = new ArrayList<WeixinMenuModel>();
		subs.add(root1);
		root2.setSub_menu(subs);

		tree.add(root2);

		WeixinMenuServiceImpl test = new WeixinMenuServiceImpl();
		System.out.println(test.weixinMenuJsonBuilder(tree));

	}

	public void setWeixinMenuMapper(WeixinMenuMapper weixinMenuMapper) {
		this.weixinMenuMapper = weixinMenuMapper;
	}

	public void setAccessTokenService(IAccessTokenService accessTokenService) {
		this.accessTokenService = accessTokenService;
	}

}
