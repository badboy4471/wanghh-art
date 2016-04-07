package com.whh.art.service;

import java.util.List;

import com.whh.art.dao.model.WeixinMenuModel;

public interface IWeixinService {
	
	public void createWeixinMenu2MP(List<WeixinMenuModel> menus);
	
	public void deleteWeixinMenuFromMP();
	
	public String getWeixinMenuFromMP();
	
	public String weixinMenuJsonBuilder(List<WeixinMenuModel> tree);

	public void addWeixinMenu2DB(WeixinMenuModel menu);
	
	public List<WeixinMenuModel> loadWeixinMenus();
	
	public void deleteWeixinMenuFromDB(int id);
	
	public WeixinMenuModel getWeixinMenuFromDB(int id);
}
