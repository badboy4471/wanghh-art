package com.whh.art.dao.mapper;

import java.util.List;

import com.whh.art.dao.model.AdminModel;
import com.whh.art.dao.model.SearchModel;
import com.whh.art.dao.model.WxUserModel;

public interface AdminMapper {
	
	AdminModel getAdminById(int id);
	
	AdminModel getAdmin(String name);
	
	AdminModel insertAdmin(AdminModel admin);
	
	void updateAdmin(AdminModel admin);
	
	void insertUser(WxUserModel user);
	
	WxUserModel getUser(String openid);
	
	List<WxUserModel> loadUsers(SearchModel search);
	
	int countUsers(SearchModel search);
	
	void deleteUser(String openid);

}
