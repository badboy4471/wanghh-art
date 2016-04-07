package com.whh.art.dao.model;

import java.util.List;

public class WeixinMenuModel {

	private int id;
	private int pid;
	private String type;
	private String name;
	private String key;
	private String url;
	private List<WeixinMenuModel> sub_nemu;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPid() {
		return pid;
	}


	public List<WeixinMenuModel> getSub_nemu() {
		return sub_nemu;
	}

	public void setSub_nemu(List<WeixinMenuModel> sub_nemu) {
		this.sub_nemu = sub_nemu;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}
}
