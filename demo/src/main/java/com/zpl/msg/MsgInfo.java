package com.zpl.msg;

public class MsgInfo {

	private String code;

	private String info;

	public MsgInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MsgInfo(String code, String info) {
		super();
		this.code = code;
		this.info = info;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

}
