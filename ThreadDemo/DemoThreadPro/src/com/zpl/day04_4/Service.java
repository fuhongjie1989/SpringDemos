package com.zpl.day04_4;

import java.util.concurrent.TimeUnit;

public class Service {

	private String username;
	private String pass;
	private String anystr=new String();
	public void setUserNameAndPass(String uname,String password){
		synchronized(anystr){
			System.out.println("�߳�"+Thread.currentThread().getName()+"��"+System.currentTimeMillis()+"����ͬ����");
			username=uname;
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pass=password;
			System.out.println("�߳�"+Thread.currentThread().getName()+"��"+System.currentTimeMillis()+"�뿪ͬ����");
		}
		
	}
}
