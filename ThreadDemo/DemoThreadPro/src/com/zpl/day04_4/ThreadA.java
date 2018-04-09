package com.zpl.day04_4;

public class ThreadA extends Thread {

	private Service service;

	public ThreadA(Service service) {
		super();
		this.service = service;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		service.setUserNameAndPass("a", "aaa");
		super.run();
	}
}
