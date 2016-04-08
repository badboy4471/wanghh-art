package com.whh.art.service;

import java.util.List;
import java.util.Set;

import com.whh.art.dao.model.AdminModel;
import com.whh.art.dao.model.SearchModel;
import com.whh.art.dao.model.SystemActionModel;
import com.whh.art.dao.model.WxUserModel;

public interface IAdminService {
	
	AdminModel getAdmin(int id);
	
	AdminModel login(String userName,String password);
	
	void updateAdmin(AdminModel admin);
	
	void insertUser(WxUserModel user);
	
	void deleteUser(String openid);
	
	List<WxUserModel> loadUsers(SearchModel search);
	
	int countUsers(SearchModel search);
	
	/**
	 * 获取当前用户的系统功能权限
	 * @param adminId
	 * @return
	 */
	public Set<SystemActionModel> loadSystemActions(int adminId);

}
