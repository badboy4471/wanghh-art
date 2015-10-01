package com.whh.art.web.form;

public class Result {
	
	private int code;
	private String message;
	private Object data;
	private long iTotalRecords;  
    private long iTotalDisplayRecords;  
    private String sEcho;
    private Object aaData;
	
	
	public Result(Object data) {
		this.code = 200;
		this.message = "操作成功";
		this.data = data;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public long getiTotalRecords() {
		return iTotalRecords;
	}
	public void setiTotalRecords(long iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}
	public long getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}
	public void setiTotalDisplayRecords(long iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}
	public String getsEcho() {
		return sEcho;
	}
	public void setsEcho(String sEcho) {
		this.sEcho = sEcho;
	}
	public Object getAaData() {
		return aaData;
	}
	public void setAaData(Object aaData) {
		this.aaData = aaData;
	}
	
	
}
