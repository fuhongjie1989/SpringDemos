package com.zpl.day05_1.innerClass;

import java.util.concurrent.TimeUnit;

public class OutClass {

	static class InnerClass1 {
		public void method1(InnerClass2 class2) {
			String threadName = Thread.currentThread().getName();
			synchronized (class2) {
				// ������
				System.out.println(threadName + " ����InnerClass1���е�method1����");
				for (int i = 0; i < 10; i++) {
					System.out.println(threadName + " i=" + i);
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(threadName + " �뿪InnerClass1���е�method1����");
			}

		}

		synchronized public void method2() {
			String threadName = Thread.currentThread().getName();
			// ������
			System.out.println(threadName + " ����InnerClass1���е�method2����");
			for (int i = 0; i < 10; i++) {
				System.out.println(threadName + " i=" + i);
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(threadName + " �뿪InnerClass1���е�method2����");
		}
	}

	static class InnerClass2 {
		// �������InnerClass�Ķ�����
		synchronized public void method1() {
			String threadName = Thread.currentThread().getName();
			// ������
			System.out.println(threadName + " ����InnerClass2���е�method1����");
			for (int i = 0; i < 10; i++) {
				System.out.println(threadName + " i=" + i);
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(threadName + " �뿪InnerClass2���е�method1����");
		}
	}
}
