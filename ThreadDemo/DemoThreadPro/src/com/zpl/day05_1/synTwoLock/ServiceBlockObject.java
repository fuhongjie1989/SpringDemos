package com.zpl.day05_1.synTwoLock;

import java.util.concurrent.TimeUnit;

/**
 * �Ƚ�synchronized���εľ�̬������synchronized(class)ͬ�������
 * 
 * @author zhangpengliang
 *
 */
public class ServiceBlockObject {
	/**
	 * ��̬����A
	 */
	synchronized public static void printA() {
		try {
			System.out.println("��ǰ�߳�����" + Thread.currentThread().getName()
					+ " ��" + System.currentTimeMillis() + " ����printA");
			TimeUnit.SECONDS.sleep(3);
			System.out.println("��ǰ�߳�����" + Thread.currentThread().getName()
					+ " ��" + System.currentTimeMillis() + " �뿪printA");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ͬ�������-->����
	 */
	public static void printB() {
		synchronized (ServiceBlockObject.class) {
			System.out.println("��ǰ�߳�����" + Thread.currentThread().getName()
					+ " ��" + System.currentTimeMillis() + " ����printB");
			System.out.println("��ǰ�߳�����" + Thread.currentThread().getName()
					+ " ��" + System.currentTimeMillis() + " �뿪printB");
		}

	}

}
