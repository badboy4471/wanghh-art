package com.whh.art.dao.model;

import java.util.Date;

public class BatchModel {

	private int id;
	private String batchNumber;
	private String batchName;
	private Date createTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBatchNumber() {
		return batchNumber;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "BatchModel [id=" + id + ", batchNumber=" + batchNumber
				+ ", batchName=" + batchName + ", createTime=" + createTime
				+ "]";
	}

}
