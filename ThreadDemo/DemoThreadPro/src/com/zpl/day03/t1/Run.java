package com.zpl.day03.t1;

public class Run {

	public static void main(String[] args) {
		MyObject obj=new MyObject();//����Ķ���
		
		ThreadA a=new ThreadA(obj);
		a.setName("ThreadA");
		
		ThreadB b=new ThreadB(obj);
		b.setName("ThreadB");
		
		a.start();
		b.start();
		
	}

}
