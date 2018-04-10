package com.zpl.day05_1;

public class ThreadB extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		Service.printB();// 调用方法B
	}
}
