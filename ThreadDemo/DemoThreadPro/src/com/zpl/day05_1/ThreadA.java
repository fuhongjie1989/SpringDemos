package com.zpl.day05_1;

public class ThreadA extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		Service.printA();// 线程A调用A
	}
}
