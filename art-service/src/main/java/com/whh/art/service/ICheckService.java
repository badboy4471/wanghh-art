package com.whh.art.service;

import com.whh.art.dao.model.ReceiptModel;

public interface ICheckService {
	
	/**
	 * 添加审核单据并提交审核
	 * @param receipt
	 */
	void addReceipt(ReceiptModel receipt,int[] uids);
	
	/**
	 * 添加审核单据
	 * @param receipt
	 */
	void addReceipt(ReceiptModel receipt);
	
	/**
	 * 提交审核
	 * @param receiptId
	 * @param uids
	 */
	void submitCheck(int receiptId,int[] uids);
}
