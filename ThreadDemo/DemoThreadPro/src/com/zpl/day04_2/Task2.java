package com.zpl.day04_2;

import java.util.concurrent.TimeUnit;

public class Task2 {

	private String data1;
	private String data2;

	public void doLongTimeTask() {
		String data11 = "ThreadName=" + Thread.currentThread().getName() + "ϵͳʱ�䣺" + System.currentTimeMillis();
		String data22 = "ThreadName=" + Thread.currentThread().getName() + "ϵͳʱ�䣺" + System.currentTimeMillis();
		
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
			System.out.println(data1);//������������,��Ȼ���������ݡ���A�ͷ���֮��,B��ȡ����,���޸����ݴ�ʱA�ſ�ʼ��ӡ��Ȼ�����������
			System.out.println(data2);//ԭ������ڲ���ͬ�������о����첽ִ��
		}
//		System.out.println(data1);
//		System.out.println(data2);
		
		System.out.println("end task2");

	}

}
