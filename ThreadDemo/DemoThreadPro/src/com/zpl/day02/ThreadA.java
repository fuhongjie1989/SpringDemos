package com.zpl.day02;

public class ThreadA extends Thread{

	private HasSelfPrivateNum numRef;
	public ThreadA(HasSelfPrivateNum numRef){
		super();
		this.numRef=numRef;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		numRef.addI("a");
	}
}
