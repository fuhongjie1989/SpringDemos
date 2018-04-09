package com.zpl.day03.t4;

public class ThreadA extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		SubMain sub=new SubMain();
		sub.operateISubMethod();
	}
}
