package com.zpl.day04_1;

import java.util.concurrent.TimeUnit;

public class SubMain extends ParentMain{
	public  void serviceMethod() throws Exception{
		System.out.println("----���ø���ķ��� ThreadName="+Thread.currentThread().getName()
				+"��ǰϵͳʱ��Ϊ"+System.currentTimeMillis());
		TimeUnit.SECONDS.sleep(3);
		System.out.println("-----sleep3����,���ø���ķ��� ThreadName="+Thread.currentThread().getName()
				+"��ǰϵͳʱ��Ϊ"+System.currentTimeMillis());
		super.serviceMethod();
	}
}
