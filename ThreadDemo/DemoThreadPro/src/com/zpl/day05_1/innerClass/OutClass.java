package com.zpl.day05_1.innerClass;

import java.util.concurrent.TimeUnit;

public class OutClass {

	static class InnerClass1 {
		public void method1(InnerClass2 class2) {
			String threadName = Thread.currentThread().getName();
			synchronized (class2) {
				// 对象锁
				System.out.println(threadName + " 进入InnerClass1类中的method1方法");
				for (int i = 0; i < 10; i++) {
					System.out.println(threadName + " i=" + i);
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(threadName + " 离开InnerClass1类中的method1方法");
			}

		}

		synchronized public void method2() {
			String threadName = Thread.currentThread().getName();
			// 对象锁
			System.out.println(threadName + " 进入InnerClass1类中的method2方法");
			for (int i = 0; i < 10; i++) {
				System.out.println(threadName + " i=" + i);
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(threadName + " 离开InnerClass1类中的method2方法");
		}
	}

	static class InnerClass2 {
		// 这个锁是InnerClass的对象锁
		synchronized public void method1() {
			String threadName = Thread.currentThread().getName();
			// 对象锁
			System.out.println(threadName + " 进入InnerClass2类中的method1方法");
			for (int i = 0; i < 10; i++) {
				System.out.println(threadName + " i=" + i);
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(threadName + " 离开InnerClass2类中的method1方法");
		}
	}
}
