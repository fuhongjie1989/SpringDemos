package com.zpl.day05_1.synTwoLock;

import java.util.concurrent.TimeUnit;

/**
 * 这里我们添加两个不同的锁，<br>
 * 来验证synchronized关键字修饰static静态方法是Class类锁<br>
 * 和修饰非静态方法的对象锁不是一个锁
 * 
 * @author zhangpengliang
 *
 */
public class ServiceTask {
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

	synchronized public static void printB() {
		System.out.println("当前线程名：" + Thread.currentThread().getName() + " 在"
				+ System.currentTimeMillis() + " 进入printB");
		System.out.println("当前线程名：" + Thread.currentThread().getName() + " 在"
				+ System.currentTimeMillis() + " 离开printB");
	}

	/**
	 * 非静态方法
	 */
	synchronized public void printC() {
		System.out.println("当前线程名：" + Thread.currentThread().getName() + " 在"
				+ System.currentTimeMillis() + " 进入printC");
		System.out.println("当前线程名：" + Thread.currentThread().getName() + " 在"
				+ System.currentTimeMillis() + " 离开printC");
	}
}
