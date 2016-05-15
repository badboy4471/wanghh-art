package com.whh.art.dao.model;

import java.util.Date;

/**
 * 审批单
 * 
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

	public static enum ReceiptType {
		IN(1), // 入库
		OUT(2);// 出库

		int code;

		ReceiptType(int code) {
			this.code = code;
		}

		public int getCode() {
			return this.code;
		}

	}

	/**
	 * 0:待提交审核 1:审核中 2:审核通过 3:审核不通过
	 * 
	 * @author tiger
	 * 
	 */

	public static enum ReceiptStatus {
		WAIT(0), //等待提交
		CHECKING(1), //审核中
		PASS(2), //通过
		REJECT(3);//不通过

		int code;

		ReceiptStatus(int code) {
			this.code = code;
		}

		public int getCode() {
			return this.code;
		}
	}

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
