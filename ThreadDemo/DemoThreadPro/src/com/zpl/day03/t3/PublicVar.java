package com.zpl.day03.t3;

import java.util.concurrent.TimeUnit;

/**
 * 共享对象中存在实例变量时可能会造成·脏读·现象
 * 
 * @author zhangpengliang
 *
 */
public class PublicVar {

	public String username = "A";
	public String password = "AA";

	public synchronized void setValue(String username, String password) {
		this.username = username;
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.password = password;
		System.out.println("setValue method thread name=" + Thread.currentThread().getName() + "username=" + username
				+ " password=" + password);
	}

	/**
	 * 当getValue方法没有被synchronized关键字修饰时,就会出现脏读<br>
	 * 原因:A线程调用setValue方法获取对象锁,而B线程调用getValue并不需要对象锁异步执行,这时候读取共享对象内存区域的信息时， <br>
	 * 可能存在误差（set与get冲突）,造成脏读
	 */
	public synchronized void getValue() {
		System.out.println("getValue method thread name=" + Thread.currentThread().getName() + " username=" + username
				+ " password=" + password);
	}

}
