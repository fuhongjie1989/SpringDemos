package com.zpl.day04_1;

import java.util.concurrent.TimeUnit;

/**
 * 父类
 * @author zhangpengliang
 *
 */
public class ParentMain {

	public synchronized void serviceMethod() throws Exception{
		System.out.println("调用父类的方法 ThreadName="+Thread.currentThread().getName()
				+"当前系统时间为"+System.currentTimeMillis());
		TimeUnit.SECONDS.sleep(3);
		System.out.println("sleep3秒手,调用父类的方法 ThreadName="+Thread.currentThread().getName()
				+"当前系统时间为"+System.currentTimeMillis());
	}
}
