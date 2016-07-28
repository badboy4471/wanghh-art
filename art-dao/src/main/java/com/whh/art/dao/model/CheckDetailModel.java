package com.whh.art.dao.model;

public class CheckDetailModel extends ArtModel {
	
	private int come;
	private int type;
	private int receiptId;
	private int ceeateUid;
	
	public int getCome() {
		return come;
	}
	public void setCome(int come) {
		this.come = come;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getReceiptId() {
		return receiptId;
	}
	public void setReceiptId(int receiptId) {
		this.receiptId = receiptId;
	}
	public int getCeeateUid() {
		return ceeateUid;
	}
	public void setCeeateUid(int ceeateUid) {
		this.ceeateUid = ceeateUid;
	}
	@Override
	public String toString() {
		return "CheckDetailModel [come=" + come + ", type=" + type
				+ ", receiptId=" + receiptId + ", ceeateUid=" + ceeateUid + "]";
	}
	
}
