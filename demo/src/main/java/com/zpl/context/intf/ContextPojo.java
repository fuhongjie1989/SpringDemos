package com.zpl.context.intf;

public class ContextPojo {
	/**
	 * 请求类型
	 */
	private String requestType = "";
	/**
	 * 线程ID
	 */
	private String threadUUID = "";
	
	private User user=new User();

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getThreadUUID() {
		return threadUUID;
	}

	public void setThreadUUID(String threadUUID) {
		this.threadUUID = threadUUID;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
