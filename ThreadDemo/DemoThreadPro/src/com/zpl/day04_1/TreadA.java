package com.zpl.day04_1;

public class TreadA extends Thread {

	private SubMain sub;

	public TreadA(SubMain sub) {
		super();
		this.sub = sub;
	}
	
	@Override
	public void run() {
		super.run();
		try {
			sub.serviceMethod();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
