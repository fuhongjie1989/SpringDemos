package com.zpl.day05_1;

import java.util.concurrent.TimeUnit;

public class Service {
	/**
	 * ��̬����
	 */
	synchronized public static void printA() {
		try {
			System.out.println("�߳�����Ϊ��" + Thread.currentThread().getName() + " ��" + System.currentTimeMillis() + "����A");
			TimeUnit.SECONDS.sleep(2);
			System.out.println("�߳���Ϊ��" + Thread.currentThread().getName() + " ��" + System.currentTimeMillis() + "�뿪A");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	synchronized public static void printB() {
		System.out.println("�߳���Ϊ��" + Thread.currentThread().getName() + " ��" + System.currentTimeMillis() + "����B");
		System.out.println("�߳���Ϊ��" + Thread.currentThread().getName() + " ��" + System.currentTimeMillis() + "�뿪B");
	}
}
