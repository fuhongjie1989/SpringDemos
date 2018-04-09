package com.zpl.day03.t2;

import java.util.concurrent.TimeUnit;
/**
 * 共享对象
 * @author zhangpengliang
 *
 */
public class MyObject {
	/**
	 * 带关键字synchronized
	 */
	synchronized public void methodA(){
		System.out.println("begin methodA threadname="+Thread.currentThread().getName());
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("end endTime="+System.currentTimeMillis());
	}
	/**
	 * 1.带synchronized
	 * 2.不带synchronized
	 */
	synchronized public void methodB(){
		try {
			System.out.println("begin methodB threadname="+Thread.currentThread().getName()
					+" begintime="+System.currentTimeMillis());
			TimeUnit.SECONDS.sleep(3);
			System.out.println("end endTime="+System.currentTimeMillis());
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}
}
