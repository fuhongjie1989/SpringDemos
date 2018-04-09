package com.zpl.day03.t1;

public class ThreadB extends Thread {

	private MyObject obj;

	public ThreadB(MyObject obj) {
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
