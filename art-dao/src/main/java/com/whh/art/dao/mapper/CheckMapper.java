package com.whh.art.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.whh.art.dao.model.CheckDetailModel;
import com.whh.art.dao.model.CheckNodeModel;
import com.whh.art.dao.model.ReceiptModel;
import com.whh.art.dao.model.SearchModel;

public interface CheckMapper {
	
	/**
	 * 添加审核单
	 * @param receipt
	 */
	void addReceipt(ReceiptModel receipt);
	
	/**
	 * 添加审核流程
	 * @param process
	 */
	void addCheckNode(CheckNodeModel process);
	
	/**
	 * 更新审核单
	 * @param receipt
	 */
	void upadteReceipt(ReceiptModel receipt);
	
	/**
	 * 更新审核单
	 * @param process
	 */
	void updateCheckProcess(CheckNodeModel process);
	
	/**
	 * 获取审核单
	 * @param id
	 * @return
	 */
	ReceiptModel getReceipt(int id);
	
	/**
	 * 获取审核流程节点
	 * @param id
	 * @return
	 */
	CheckNodeModel getCheckNode(int id);
	
	/**
	 * 获取审核单的流程
	 * @param receiptId
	 * @return
	 */
	List<CheckNodeModel> getCheckProcess(int receiptId);
	
	/**
	 * 获取我发起的审核单
	 * @param uid
	 * @return
	 */
	List<ReceiptModel> loadReceipts(@Param("uid")int uid,@Param("search") SearchModel search);
	
	/**
	 * 
	 * @param uid
	 * @param search
	 * @return
	 */
	int countReceipts(@Param("uid")int uid,@Param("search") SearchModel search);
	
	int insertCheckDetail(CheckDetailModel detail);
	
}
