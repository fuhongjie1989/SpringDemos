package com.zpl.jio;

import java.util.concurrent.TimeUnit;

public class Thread1 extends Thread {
	private MapContains m;
	
	public Thread1(MapContains m) {
		super();
		this.m = m;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		synchronized(m.map){
		m.put("A", 1);
		System.out.println(m.getKey());
		System.out.println(System.currentTimeMillis()+" ");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(m.size());
		}
	}
}
