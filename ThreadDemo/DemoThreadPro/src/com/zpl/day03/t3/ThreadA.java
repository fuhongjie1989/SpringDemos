package com.zpl.day03.t3;

public class ThreadA extends Thread {

	private PublicVar var;

	public ThreadA(PublicVar var) {
		super();
		this.var = var;
	};
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		var.setValue("B", "BB");
	}
}
