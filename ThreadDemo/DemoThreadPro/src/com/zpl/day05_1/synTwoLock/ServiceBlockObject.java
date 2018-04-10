package com.zpl.day05_1.synTwoLock;

import java.util.concurrent.TimeUnit;

/**
 * 比较synchronized修饰的静态方法和synchronized(class)同步代码块
 * 
 * @author zhangpengliang
 *
 */
public class ServiceBlockObject {
	/**
	 * 静态方法A
	 */
	synchronized public static void printA() {
		try {
			System.out.println("当前线程名：" + Thread.currentThread().getName()
					+ " 在" + System.currentTimeMillis() + " 进入printA");
			TimeUnit.SECONDS.sleep(3);
			System.out.println("当前线程名：" + Thread.currentThread().getName()
					+ " 在" + System.currentTimeMillis() + " 离开printA");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 同步代码块-->类锁
	 */
	public static void printB() {
		synchronized (ServiceBlockObject.class) {
			System.out.println("当前线程名：" + Thread.currentThread().getName()
					+ " 在" + System.currentTimeMillis() + " 进入printB");
			System.out.println("当前线程名：" + Thread.currentThread().getName()
					+ " 在" + System.currentTimeMillis() + " 离开printB");
		}

	}

}
