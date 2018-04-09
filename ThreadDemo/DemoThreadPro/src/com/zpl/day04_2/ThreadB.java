package com.zpl.day04_2;

public class ThreadB extends Thread {

	private Task2 task;

	public ThreadB(Task2 task) {
		super();
		this.task = task;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println("B ¿ªÊ¼"+System.currentTimeMillis());
		task.doLongTimeTask();
		System.out.println("B ½áÊø"+System.currentTimeMillis());
	}
	

}
