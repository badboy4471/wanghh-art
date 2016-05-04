package com.whh.art.service;

import com.whh.art.dao.mapper.CheckMapper;
import com.whh.art.dao.model.CheckNodeModel;
import com.whh.art.dao.model.ReceiptModel;

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

	public void setCheckMapper(CheckMapper checkMapper) {
		this.checkMapper = checkMapper;
	}

	
}
