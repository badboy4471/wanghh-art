package com.whh.art.service;

import com.whh.art.dao.model.AdminModel;

public interface IAdminService {
	
	AdminModel getAdmin(int id);
	
	AdminModel login(String userName,String password);

}
