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
	void updateReceipt(ReceiptModel receipt);
	
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
	 * 通过用户ID和审核单Id获取审核节点
	 * @param id
	 * @return
	 */
	CheckNodeModel getCheckNodeByUidAndReceiptId(@Param("uid")int uid,@Param("receiptId")int receiptId);
	
	/**
	 * 获取审核单的流程
	 * @param receiptId
	 * @return
	 */
	List<CheckNodeModel> loadCheckProcesses(int receiptId);
	
	/**
	 * 获取我发起的审核单
	 * @param uid
	 * @return
	 */
	List<ReceiptModel> loadReceipts(@Param("uid")int uid,@Param("search") SearchModel search);
	
	/**
	 * 获取需要我审核的审核单
	 * @param uid
	 * @param search
	 * @return
	 */
	List<ReceiptModel> loadMyCheckReceipts(@Param("uid") int uid,@Param("search") SearchModel search);
	
	/**
	 * 
	 * @param uid
	 * @param search
	 * @return
	 */
	int countReceipts(@Param("uid")int uid,@Param("search") SearchModel search);
	
	int insertCheckDetail(CheckDetailModel detail);
	
	CheckDetailModel getCheckDetail(String artNumber);
	
	List<CheckDetailModel> searchCheckDetail(SearchModel search);
	
	int countCheckDetail(SearchModel search);
	
	/**
	 * 计算
	 * @param receiptId
	 * @return
	 */
	int countNoCheckProcess(int receiptId);
	
	/**
	 * 查看审核流程
	 * @param receiptid
	 * @return
	 */
	List<CheckNodeModel> showCheckProcess(int receiptid);
	
}
