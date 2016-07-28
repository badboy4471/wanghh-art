package com.whh.art.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.whh.art.dao.mapper.AdminMapper;
import com.whh.art.dao.model.AdminModel;
import com.whh.art.dao.model.SearchModel;
import com.whh.art.dao.model.SystemActionModel;
import com.whh.art.dao.model.SystemRoleModel;
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
		if (u == null) {
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

	@Override
	public Set<SystemActionModel> loadSystemActions(int adminId) {
		Set<SystemActionModel> actions = new HashSet<SystemActionModel>();
		List<SystemRoleModel> roles = adminMapper.getAdminRole(adminId);
		if (roles != null) {
			for (SystemRoleModel role : roles) {
				List<SystemActionModel> actions1 = adminMapper
						.loadRoleRight(role.getRole_key());
				actions.addAll(actions1);
			}
		}
		return actions;
	}

	@Override
	public List<AdminModel> loadAllAdmin(){
		return adminMapper.loadAllAdmin();
	}
}
