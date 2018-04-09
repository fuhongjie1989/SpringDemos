package com.zpl.day04_1;

public class ThreadB extends Thread {

	private SubMain sub;

	public ThreadB(SubMain sub) {
		super();
		this.sub = sub;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			sub.serviceMethod();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
