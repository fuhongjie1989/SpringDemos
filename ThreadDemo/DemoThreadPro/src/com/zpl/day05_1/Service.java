package com.zpl.day05_1;

import java.util.concurrent.TimeUnit;

public class Service {
	/**
	 * 静态方法
	 */
	synchronized public static void printA() {
		try {
			System.out.println("线程名称为：" + Thread.currentThread().getName() + " 在" + System.currentTimeMillis() + "进入A");
			TimeUnit.SECONDS.sleep(2);
			System.out.println("线程名为：" + Thread.currentThread().getName() + " 在" + System.currentTimeMillis() + "离开A");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	synchronized public static void printB() {
		System.out.println("线程名为：" + Thread.currentThread().getName() + " 在" + System.currentTimeMillis() + "进入B");
		System.out.println("线程名为：" + Thread.currentThread().getName() + " 在" + System.currentTimeMillis() + "离开B");
	}
}
