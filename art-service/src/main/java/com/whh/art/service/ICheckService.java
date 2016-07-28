package com.whh.art.service;

import java.util.List;

import com.whh.art.dao.model.CheckDetailModel;
import com.whh.art.dao.model.ReceiptModel;
import com.whh.art.dao.model.SearchModel;

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
	
	/**
	 * 获取我的审核单
	 * @param uid
	 * @param status
	 * @return
	 */
	List loadMyReceipt(int uid,SearchModel search);
	
	CheckDetailModel insertCheckDetail(CheckDetailModel model);
	
	CheckDetailModel getCheckDetail(String artNumber);
	
	List<CheckDetailModel> searchCheckdetail(SearchModel search);
	
	int countCheckDetail(SearchModel search);
}
