package com.zpl.day02.more;

public class ThreadA extends Thread {
	private HasselfPrivateNums num=new HasselfPrivateNums();

	public ThreadA(HasselfPrivateNums num) {
		super();
		this.num = num;
	}
	
	@Override
	public void run() {
		super.run();
		num.addI("a");
	}
}
