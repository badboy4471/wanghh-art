package com.whh.art.service;

import java.util.List;

import com.whh.art.dao.mapper.CheckMapper;
import com.whh.art.dao.model.CheckDetailModel;
import com.whh.art.dao.model.CheckNodeModel;
import com.whh.art.dao.model.ReceiptModel;
import com.whh.art.dao.model.SearchModel;

public class CheckServiceImpl implements ICheckService {

	CheckMapper checkMapper;

	@Override
	public void addReceipt(ReceiptModel receipt, int[] uids) {
		try {
			checkMapper.addReceipt(receipt);
			int parentId = 0;
			if (receipt.getId() > 0) {
				for (int i = 0; i < uids.length; i++) {
					CheckNodeModel checkNode = new CheckNodeModel();
					checkNode.setCheckUid(uids[i]);
					checkNode.setParentId(parentId);
					checkNode.setReceiptId(receipt.getId());
					checkMapper.addCheckNode(checkNode);
					if (checkNode.getId() > 0) {
						parentId = checkNode.getId();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void addReceipt(ReceiptModel receipt) {
		try {
			checkMapper.addReceipt(receipt);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void submitCheck(int receiptId, int[] uids) {
		try {
			int parentId = 0;
			for (int i = 0; i < uids.length; i++) {
				CheckNodeModel checkNode = new CheckNodeModel();
				checkNode.setCheckUid(uids[i]);
				checkNode.setParentId(parentId);
				checkNode.setReceiptId(receiptId);
				checkNode.setStatus(0);//待审核
				checkMapper.addCheckNode(checkNode);
				if (checkNode.getId() > 0) {
					parentId = checkNode.getId();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	@Override
	public List loadMyReceipt(int uid, SearchModel search) {
		
		return checkMapper.loadReceipts(uid, search);
	}
	

	public void setCheckMapper(CheckMapper checkMapper) {
		this.checkMapper = checkMapper;
	}

	@Override
	public CheckDetailModel insertCheckDetail(CheckDetailModel model) {
		try{
			checkMapper.insertCheckDetail(model);
			return model;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public CheckDetailModel getCheckDetail(String artNumber) {
		return checkMapper.getCheckDetail(artNumber);
	}

	@Override
	public List<CheckDetailModel> searchCheckdetail(SearchModel search) {
		return checkMapper.searchCheckDetail(search);
	}

	@Override
	public int countCheckDetail(SearchModel search) {
		return checkMapper.countCheckDetail(search);
	}

	@Override
	public void updateReceipt(ReceiptModel receipt) {
		checkMapper.updateReceipt(receipt);
	}

	@Override
	public ReceiptModel getReceipt(int id) {
		return checkMapper.getReceipt(id);
	}

	@Override
	public List<ReceiptModel> loadMyCheckReceipts(int uid, SearchModel search) {
		return checkMapper.loadMyCheckReceipts(uid, search);
	}

	@Override
	public boolean canCheck(int receiptId, int uid) {
		CheckNodeModel node = checkMapper.getCheckNodeByUidAndReceiptId(uid, receiptId);
		if (node == null){
			return false;
		}else{
			if (node.getStatus() != 0){
				return false;
			}else{
				return true;
			}
		}
	}

	@Override
	public boolean isFinishCheckProcess(int receiptId) {
		int count = checkMapper.countNoCheckProcess(receiptId);
		return count == 0;
	}

	@Override
	public void updateCheckProcess(CheckNodeModel node) {
		checkMapper.updateCheckProcess(node);
		
	}

	@Override
	public CheckNodeModel getCheckNodeByUidAndReceiptId(int receiptId, int uid) {
		return checkMapper.getCheckNodeByUidAndReceiptId(uid, receiptId);
	}

	@Override
	public List<CheckNodeModel> loadCheckProcesses(int receiptId) {
		return checkMapper.loadCheckProcesses(receiptId);
	}

	@Override
	public List<CheckNodeModel> showCheckProcess(int receiptId) {
		return checkMapper.showCheckProcess(receiptId);
	}

	@Override
	public void insertArt(int receiptId) {
		checkMapper.insertArt(receiptId);
		
	}
}
