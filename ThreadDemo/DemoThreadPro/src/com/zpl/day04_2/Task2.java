package com.zpl.day04_2;

import java.util.concurrent.TimeUnit;

public class Task2 {

	private String data1;
	private String data2;

	public void doLongTimeTask() {
		String data11 = "ThreadName=" + Thread.currentThread().getName() + "系统时间：" + System.currentTimeMillis();
		String data22 = "ThreadName=" + Thread.currentThread().getName() + "系统时间：" + System.currentTimeMillis();
		
		System.out.println("begin task2");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized(this){
			data1=data11;
			data2=data22;
			System.out.println(data1);//如果这个在外面,必然导致脏数据。当A释放锁之后,B获取到锁,并修改数据此时A才开始打印必然会出现脏数据
			System.out.println(data2);//原因就在于不在同步语句块中就是异步执行
		}
//		System.out.println(data1);
//		System.out.println(data2);
		
		System.out.println("end task2");

	}

}
