package com.whh.art.service;

import java.util.List;

import com.whh.art.dao.model.AdminModel;
import com.whh.art.dao.model.SearchModel;
import com.whh.art.dao.model.WxUserModel;

public interface IAdminService {
	
	AdminModel getAdmin(int id);
	
	AdminModel login(String userName,String password);
	
	void insertUser(WxUserModel user);
	
	void deleteUser(String openid);
	
	List<WxUserModel> loadUsers(SearchModel search);
	
	int countUsers(SearchModel search);

}
