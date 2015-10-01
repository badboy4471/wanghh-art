package com.whh.art.dao.model;

import java.util.Date;

public class OptLogModel {
	
	private int id;
	private Date time;
	private int adminId;
	private String url;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "OptLogModel [id=" + id + ", time=" + time + ", adminId="
				+ adminId + ", url=" + url + "]";
	}
	
}
