package com.whh.art.dao.model;

public class SystemActionModel {
	
	private int id;
	private String action_key;
	private String memo;
	private String type;
	private String action;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAction_key() {
		return action_key;
	}
	public void setAction_key(String action_key) {
		this.action_key = action_key;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
}
