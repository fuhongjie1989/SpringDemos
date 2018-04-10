package com.zpl.day05_1.innerClass;

import com.zpl.day05_1.innerClass.OutClass.InnerClass1;
import com.zpl.day05_1.innerClass.OutClass.InnerClass2;

/**
 * 线程A和线程C共享一个对象class2.都是对象锁<br>
 * 线程B是class1的对象锁
 * 
 * @author zhangpengliang
 *
 */
public class OutClassRun {

	public static void main(String[] args) {
		final InnerClass1 class1 = new InnerClass1();
		final InnerClass2 class2 = new InnerClass2();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				class1.method1(class2);
			}
		}, "A");
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				class1.method2();
			}
		}, "B");
		Thread t3 = new Thread(new Runnable() {
			public void run() {
				class2.method1();
			}
		}, "C");

		t1.start();
		t2.start();
		t3.start();

	}

}
