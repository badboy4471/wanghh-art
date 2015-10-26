package com.whh.art.dao.model;

import java.util.Date;

public class ArtOutModel {
	
	private int id;
	private Date createTime;
	private ArtModel art;
	private String type;
	private String memo;
	private Date backTime;
	
	public static enum OutType{
		RENT, //出租
		SELL;//出售
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public ArtModel getArt() {
		return art;
	}

	public void setArt(ArtModel art) {
		this.art = art;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Date getBackTime() {
		return backTime;
	}

	public void setBackTime(Date backTime) {
		this.backTime = backTime;
	}

}
