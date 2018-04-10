package com.zpl.day05_1.synTwoLock;

/**
 * 验证synchronized修饰的静态方法与synchronized(class)代码块是同一个锁
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
