package com.zpl.day03.t2;

public class Run {

	public static void main(String[] args) {
		//������ʵ��ʵ����һ����,java�з����ʵ������ʵ��=����
		MyObject obj=new MyObject();//�ö����ǹ������ 
		ThreadA a=new ThreadA(obj);
		a.setName("ThreadA");
		ThreadB b=new ThreadB(obj);
		b.setName("ThreadB");
		a.start();
		b.start();
	}

}
