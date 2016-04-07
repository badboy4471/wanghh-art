package com.whh.art.dao.model;

import java.util.List;

public class WeixinMenuModel {

	private int id;
	private int pid;
	private String type;
	private String name;
	private String key;
	private String url;
	private String media_id;
	private List<WeixinMenuModel> sub_menu;

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

	public List<WeixinMenuModel> getSub_menu() {
		return sub_menu;
	}

	public void setSub_menu(List<WeixinMenuModel> sub_menu) {
		this.sub_menu = sub_menu;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getMedia_id() {
		return media_id;
	}

	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}
}
