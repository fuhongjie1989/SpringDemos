package com.zpl.demo.login.pojo;

public class Role {

	private String rolecode;
	private String rolename;
	private String roleid;

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(String rolecode, String rolename, String roleid) {
		super();
		this.rolecode = rolecode;
		this.rolename = rolename;
		this.roleid = roleid;
	}

	public String getRolecode() {
		return rolecode;
	}

	public void setRolecode(String rolecode) {
		this.rolecode = rolecode;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
}
