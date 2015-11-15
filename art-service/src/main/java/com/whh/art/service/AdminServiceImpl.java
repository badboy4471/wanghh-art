package com.whh.art.service;

import java.util.List;

import com.whh.art.dao.mapper.AdminMapper;
import com.whh.art.dao.model.AdminModel;
import com.whh.art.dao.model.SearchModel;
import com.whh.art.dao.model.WxUserModel;

public class AdminServiceImpl implements IAdminService {

	AdminMapper adminMapper;

	@Override
	public AdminModel getAdmin(int id) {
		return adminMapper.getAdminById(id);
	}

	@Override
	public AdminModel login(String userName, String password) {
		AdminModel admin = adminMapper.getAdmin(userName);
		if (admin != null && admin.getPassword().equals(password)) {
			return admin;
		}
		return null;
	}

	public void setAdminMapper(AdminMapper adminMapper) {
		this.adminMapper = adminMapper;
	}

	@Override
	public void insertUser(WxUserModel user) {
		WxUserModel u = adminMapper.getUser(user.getOpenId());
		if (u == null){
			adminMapper.insertUser(user);
		}
	}

	@Override
	public void deleteUser(String openid) {
		adminMapper.deleteUser(openid);
		
	}

	@Override
	public List<WxUserModel> loadUsers(SearchModel search) {
		return adminMapper.loadUsers(search);
	}

	@Override
	public int countUsers(SearchModel search) {
		return adminMapper.countUsers(search);
	}

	@Override
	public void updateAdmin(AdminModel admin) {
		adminMapper.updateAdmin(admin);
	}

}
