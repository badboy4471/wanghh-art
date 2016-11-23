package com.whh.art.dao.model;

/**
 * 系统设置的回复信息
 * @author tiger
 *
 */
public class SystemCmdModel {
	
	private int id;
	private String cmdType;
	private String cmd;
	private String replyType;
	private String replyText;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCmdType() {
		return cmdType;
	}
	public void setCmdType(String cmdType) {
		this.cmdType = cmdType;
	}
	public String getCmd() {
		return cmd;
	}
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	public String getReplyType() {
		return replyType;
	}
	public void setReplyType(String replyType) {
		this.replyType = replyType;
	}
	public String getReplyText() {
		return replyText;
	}
	public void setReplyText(String replyText) {
		this.replyText = replyText;
	}
	@Override
	public String toString() {
		return "SystemCmdModel [id=" + id + ", cmdType=" + cmdType + ", cmd="
				+ cmd + ", replyType=" + replyType + ", replyText=" + replyText
				+ "]";
	}
	
}
