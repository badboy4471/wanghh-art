package com.whh.art.dao.bean;

import java.util.List;

public class WeixinMenuBean {

	private String name;
	private String type;
	private String key;
	private String url;
	private String media_id;
	private List<WeixinMenuBean> sub_button;

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

	public String getMedia_id() {
		return media_id;
	}

	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<WeixinMenuBean> getSub_button() {
		return sub_button;
	}

	public void setSub_button(List<WeixinMenuBean> sub_button) {
		this.sub_button = sub_button;
	}
}
