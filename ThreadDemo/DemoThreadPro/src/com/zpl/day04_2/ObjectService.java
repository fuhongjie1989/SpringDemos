package com.zpl.day04_2;

import java.util.concurrent.TimeUnit;

public class ObjectService {

	/**
	 * �߳�A����A����
	 */
	public void serviceMethodA(){
		synchronized(this){
			try {
				System.out.println("A������ʼʱ�� "+System.currentTimeMillis());
				TimeUnit.SECONDS.sleep(2);
				System.out.println("A��������ʱ��"+System.currentTimeMillis());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	/**
	 * �߳�B����B����
	 */
	public void serviceMethodB(){
		synchronized(this){
			try {
				System.out.println("B������ʼʱ�� "+System.currentTimeMillis());
				TimeUnit.SECONDS.sleep(2);
				System.out.println("B��������ʱ��"+System.currentTimeMillis());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
