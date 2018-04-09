package com.zpl.day03.t2;

public class ThreadA extends Thread {
	private MyObject obj;

	public ThreadA(MyObject obj) {
		super();
		this.obj = obj;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		obj.methodA();
	}
}
