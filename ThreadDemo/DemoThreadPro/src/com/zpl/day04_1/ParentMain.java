package com.zpl.day04_1;

import java.util.concurrent.TimeUnit;

/**
 * ����
 * @author zhangpengliang
 *
 */
public class ParentMain {

	public synchronized void serviceMethod() throws Exception{
		System.out.println("���ø���ķ��� ThreadName="+Thread.currentThread().getName()
				+"��ǰϵͳʱ��Ϊ"+System.currentTimeMillis());
		TimeUnit.SECONDS.sleep(3);
		System.out.println("sleep3����,���ø���ķ��� ThreadName="+Thread.currentThread().getName()
				+"��ǰϵͳʱ��Ϊ"+System.currentTimeMillis());
	}
}
