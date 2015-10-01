package com.whh.art.dao.model;

import java.util.Date;

public class AdminModel {
	
	private int id;
	private String userName;
	private String password;
	private Date createTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "AdminModel [id=" + id + ", userName=" + userName
				+ ", password=" + password + ", createTime=" + createTime + "]";
	}
	
}
