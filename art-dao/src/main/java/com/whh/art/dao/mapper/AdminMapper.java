package com.whh.art.dao.mapper;

import com.whh.art.dao.model.AdminModel;

public interface AdminMapper {
	
	AdminModel getAdminById(int id);
	
	AdminModel getAdmin(String name);
	
	AdminModel insertAdmin(AdminModel admin);
	
	void updateAdmin(AdminModel admin);

}
