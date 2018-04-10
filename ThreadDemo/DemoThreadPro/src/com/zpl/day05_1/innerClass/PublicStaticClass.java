package com.zpl.day05_1.innerClass;

/**
 * ��̬������
 * 
 * @author zhangpengliang
 *
 */
public class PublicStaticClass {

	private static String username;
	private static String password;

	static class privateStaticClass {
		private String age;
		private String address;

		public String getAge() {
			return age;
		}

		public void setAge(String age) {
			this.age = age;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
