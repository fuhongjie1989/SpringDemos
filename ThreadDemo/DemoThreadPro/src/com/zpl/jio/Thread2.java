package com.zpl.jio;

import java.util.concurrent.TimeUnit;

public class Thread2 extends Thread {
private MapContains m;
	
	public Thread2(MapContains m) {
		super();
		this.m = m;
	}

	@SuppressWarnings("static-access")
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		synchronized(m.map){
			m.put("B", 2);
			System.out.println(System.currentTimeMillis());
			System.out.println(m.getKey());
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
