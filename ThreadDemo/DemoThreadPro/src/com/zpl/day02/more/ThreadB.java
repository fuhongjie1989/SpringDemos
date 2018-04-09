package com.zpl.day02.more;

public class ThreadB extends Thread {
	private HasselfPrivateNums num=new HasselfPrivateNums();

	public ThreadB(HasselfPrivateNums num) {
		super();
		this.num = num;
	}
	
	@Override
	public void run() {
		super.run();
		num.addI("b");
	}
}
