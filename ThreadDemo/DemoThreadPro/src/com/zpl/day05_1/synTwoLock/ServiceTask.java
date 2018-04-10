package com.zpl.day05_1.synTwoLock;

import java.util.concurrent.TimeUnit;

/**
 * �����������������ͬ������<br>
 * ����֤synchronized�ؼ�������static��̬������Class����<br>
 * �����ηǾ�̬�����Ķ���������һ����
 * 
 * @author zhangpengliang
 *
 */
public class ServiceTask {
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

	synchronized public static void printB() {
		System.out.println("��ǰ�߳�����" + Thread.currentThread().getName() + " ��"
				+ System.currentTimeMillis() + " ����printB");
		System.out.println("��ǰ�߳�����" + Thread.currentThread().getName() + " ��"
				+ System.currentTimeMillis() + " �뿪printB");
	}

	/**
	 * �Ǿ�̬����
	 */
	synchronized public void printC() {
		System.out.println("��ǰ�߳�����" + Thread.currentThread().getName() + " ��"
				+ System.currentTimeMillis() + " ����printC");
		System.out.println("��ǰ�߳�����" + Thread.currentThread().getName() + " ��"
				+ System.currentTimeMillis() + " �뿪printC");
	}
}
