package com.zpl.day05_1.synTwoLock;

public class Test {
	// 运行结果说明了什么？
	// 说明：A和B是一个锁。C是一个锁。AB和C不是一个锁

	// 如果线程B用task2对象实例。可以看出与A是同步的。因为AB是一个锁--->ServiceTask.class类锁
	public static void main(String[] args) {
		final ServiceTask task = new ServiceTask();// 共享对象
		final ServiceTask task2 = new ServiceTask();// 共享对象
		Thread threadA = new Thread(new Runnable() {

			@Override
			public void run() {
				task.printA();
			}
		}, "A");
		Thread threadB = new Thread(new Runnable() {

			@Override
			public void run() {
				task2.printB();
			}
		}, "B");
		Thread threadC = new Thread(new Runnable() {

			@Override
			public void run() {
				task.printC();
			}
		}, "C");
		threadA.start();
		threadB.start();
		threadC.start();
	}

}
