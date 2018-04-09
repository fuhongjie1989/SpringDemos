package com.zpl.day04_2;

public class ThreadBService extends Thread{

	private ObjectService s;

	public ThreadBService(ObjectService s) {
		super();
		this.s = s;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		s.serviceMethodB();
	}
}
