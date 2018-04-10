package com.zpl.day05_1.synTwoLock;

/**
 * ��֤synchronized���εľ�̬������synchronized(class)�������ͬһ����
 * 
 * @author zhangpengliang
 *
 */
public class TestBlockObject {

	public static void main(String[] args) {

		Thread a = new Thread(new Runnable() {

			@Override
			public void run() {
				ServiceBlockObject.printA();
			}
		}, "A");

		Thread b = new Thread(new Runnable() {
			public void run() {
				ServiceBlockObject.printB();
			}
		}, "B");
		a.start();
		b.start();
	}

}
