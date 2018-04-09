package com.zpl.day03.t4;


public class MyThread extends Thread {

	@Override
	public void run() {
		super.run();
		Service service=new Service();
		service.service1();
	}
}
