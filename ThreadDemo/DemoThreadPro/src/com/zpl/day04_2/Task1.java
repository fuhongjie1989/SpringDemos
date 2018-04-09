package com.zpl.day04_2;

import java.util.concurrent.TimeUnit;
/**
 * 由于方法是同步的,所以全部走完得花费6秒的时间
 * @author zhangpengliang
 *
 */
public class Task1 {
	private String data1;
	private String data2;
	
	public synchronized void doLongTimeTask(){
		System.out.println("begin task1");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		data1="ThreadName="+Thread.currentThread().getName()+"系统时间："+System.currentTimeMillis();
		data2="ThreadName="+Thread.currentThread().getName()+"系统时间："+System.currentTimeMillis();
		System.out.println(data1);
		System.out.println(data2);
		System.out.println("end task1");
		
	}
	
}
