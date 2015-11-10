package com.whh.art.dao.mapper;

import java.util.List;

import com.whh.art.dao.model.AdminModel;
import com.whh.art.dao.model.SearchModel;
import com.whh.art.dao.model.UserModel;

public interface AdminMapper {
	
	AdminModel getAdminById(int id);
	
	AdminModel getAdmin(String name);
	
	AdminModel insertAdmin(AdminModel admin);
	
	void updateAdmin(AdminModel admin);
	
	void insertUser(UserModel user);
	
	UserModel getUser(String openid);
	
	List<UserModel> loadUserModel(SearchModel search);
	
	int countUsers(SearchModel search);
	
	void deleteUser(String openid);

}
