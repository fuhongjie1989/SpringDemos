package com.zpl.context.intf;

import java.io.Serializable;


/**
 * 登录用户/
 * 
 * @author zhangpengliang
 *
 */
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5541500632624084198L;

	private String id = "";

	/*
	 * 当前登录用户请求的sessionId
	 */
	private String sessionId = "";

	/**
	 * 账号ID
	 */
	private String accuntId = "";

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getAccuntId() {
		return accuntId;
	}

	public void setAccuntId(String accuntId) {
		this.accuntId = accuntId;
	}
}
