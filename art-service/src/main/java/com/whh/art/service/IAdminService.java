package com.whh.art.service;

import com.whh.art.dao.model.AdminModel;
import com.whh.art.dao.model.WxUserModel;

public interface IAdminService {
	
	AdminModel getAdmin(int id);
	
	AdminModel login(String userName,String password);
	
	void insertUser(WxUserModel user);
	
	void deleteUser(String openid);

}
