package com.zpl.day03.t1;

import java.util.concurrent.TimeUnit;

/**
 * 由于MyObject对象是一个共享对象，所以我们需要加锁来保持同步<br>
 * 添加关键字：synchronized
 * @author zhangpengliang
 *
 */
public class MyObject {

	public synchronized void methodA(){
		System.out.println("begin methodA threadName="+Thread.currentThread().getName());
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(" end");
	}
}
