package com.whh.art.service;

import com.whh.art.dao.mapper.AdminMapper;
import com.whh.art.dao.model.AdminModel;

public class AdminServiceImpl implements IAdminService {
	
	AdminMapper adminMapper;

	@Override
	public AdminModel getAdmin(int id) {
		return adminMapper.getAdminById(id);
	}

	@Override
	public AdminModel login(String userName, String password) {
		AdminModel admin = adminMapper.getAdmin(userName);
		if (admin != null && admin.getPassword().equals(password)){
			return admin;
		}
		return null;
	}

	public void setAdminMapper(AdminMapper adminMapper) {
		this.adminMapper = adminMapper;
	}
	

}
