package com.whh.art.dao.model;

import java.util.Date;

/**
 * 审批单
 * @author tiger
 *
 */
public class ReceiptModel {

	private int id;
	private String memo;
	private Date createTime;
	private int createUid;
	private int status;
	private int type;
	private Date lastUpdateTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getCreateUid() {
		return createUid;
	}
	public void setCreateUid(int createUid) {
		this.createUid = createUid;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	
	
}
