package com.zpl.day03.t1;

import java.util.concurrent.TimeUnit;

/**
 * ����MyObject������һ�������������������Ҫ����������ͬ��<br>
 * ��ӹؼ��֣�synchronized
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
