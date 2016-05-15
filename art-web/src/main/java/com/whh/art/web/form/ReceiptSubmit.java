package com.whh.art.web.form;

import java.util.Arrays;

public class ReceiptSubmit {
	
	private String memo;//备注
	
	private int type;//类型；
	
	private int[] checkUids;//审核人列表

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int[] getCheckUids() {
		return checkUids;
	}

	public void setCheckUids(int[] checkUids) {
		this.checkUids = checkUids;
	}

	@Override
	public String toString() {
		return "ReceiptSubmit [memo=" + memo + ", type=" + type
				+ ", checkUids=" + Arrays.toString(checkUids) + "]";
	}
}
