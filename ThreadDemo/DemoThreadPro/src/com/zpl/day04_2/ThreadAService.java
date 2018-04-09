package com.zpl.day04_2;


public class ThreadAService extends Thread {

	private ObjectService s;

	public ThreadAService(ObjectService s) {
		super();
		this.s = s;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		s.serviceMethodA();
	}
}
