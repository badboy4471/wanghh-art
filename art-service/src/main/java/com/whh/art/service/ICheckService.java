package com.whh.art.service;

import com.whh.art.dao.model.ReceiptModel;

public interface ICheckService {
	
	/**
	 * 添加审核单据
	 * @param receipt
	 */
	void addReceipt(ReceiptModel receipt,int[] uid);

}
