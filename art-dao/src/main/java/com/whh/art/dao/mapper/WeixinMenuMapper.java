package com.whh.art.dao.mapper;

import java.util.List;

import com.whh.art.dao.model.WeixinMenuModel;

public interface WeixinMenuMapper {
	
	public void addWeixinMenu(WeixinMenuModel menu);
	
	public void deleteWeixinMenu(int id);
	
	public WeixinMenuModel getWeixinMenu(int id);
	
	public List<WeixinMenuModel> loadWeixinMenus(int pid);

}
