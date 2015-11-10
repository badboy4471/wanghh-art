package com.whh.art.service;

import com.whh.art.dao.model.AdminModel;
import com.whh.art.dao.model.UserModel;

public interface IAdminService {
	
	AdminModel getAdmin(int id);
	
	AdminModel login(String userName,String password);
	
	void insertUser(UserModel user);
	
	void deleteUser(String openid);

}
