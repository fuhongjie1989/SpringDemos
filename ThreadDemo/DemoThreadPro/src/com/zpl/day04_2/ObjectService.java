package com.zpl.day04_2;

import java.util.concurrent.TimeUnit;

public class ObjectService {

	/**
	 * 线程A调用A方法
	 */
	public void serviceMethodA(){
		synchronized(this){
			try {
				System.out.println("A方法开始时间 "+System.currentTimeMillis());
				TimeUnit.SECONDS.sleep(2);
				System.out.println("A方法结束时间"+System.currentTimeMillis());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	/**
	 * 线程B调用B方法
	 */
	public void serviceMethodB(){
		synchronized(this){
			try {
				System.out.println("B方法开始时间 "+System.currentTimeMillis());
				TimeUnit.SECONDS.sleep(2);
				System.out.println("B方法结束时间"+System.currentTimeMillis());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
