package com.whh.art.dao.model;

import java.util.Date;

public class ArtMuseumModel {
	
	private int id;
	private int artId;
	private int museumId;
	private Date createTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getArtId() {
		return artId;
	}
	public void setArtId(int artId) {
		this.artId = artId;
	}
	public int getMuseumId() {
		return museumId;
	}
	public void setMuseumId(int museumId) {
		this.museumId = museumId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	

}
