package com.whh.art.dao.model;

import java.util.Date;

public class CheckNodeModel {
	
	private int id;
	private int receiptId;
	private int checkUid;
	private String nickName;
	private Date checkTime = new Date();
	private int status;
	private String checkMemo;
	private int parentId;//父审核节点id
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getReceiptId() {
		return receiptId;
	}
	public void setReceiptId(int receiptId) {
		this.receiptId = receiptId;
	}
	public int getCheckUid() {
		return checkUid;
	}
	public void setCheckUid(int checkUid) {
		this.checkUid = checkUid;
	}
	public Date getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getCheckMemo() {
		return checkMemo;
	}
	public void setCheckMemo(String checkMemo) {
		this.checkMemo = checkMemo;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
}
