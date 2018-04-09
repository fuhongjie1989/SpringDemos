package com.zpl.day04_2;

public class ThreadA extends Thread {
	private Task2 task;

	public ThreadA(Task2 task) {
		super();
		this.task = task;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println("A ¿ªÊ¼"+System.currentTimeMillis());
		task.doLongTimeTask();
		System.out.println("A ½áÊø"+System.currentTimeMillis());
	}
	
}
