package com.zpl.day05_1.synTwoLock;

public class Test {
	// ���н��˵����ʲô��
	// ˵����A��B��һ������C��һ������AB��C����һ����

	// ����߳�B��task2����ʵ�������Կ�����A��ͬ���ġ���ΪAB��һ����--->ServiceTask.class����
	public static void main(String[] args) {
		final ServiceTask task = new ServiceTask();// �������
		final ServiceTask task2 = new ServiceTask();// �������
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
