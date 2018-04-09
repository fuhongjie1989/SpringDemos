package com.zpl.day03.t2;

public class Run {

	public static void main(String[] args) {
		//对象其实和实例是一样的,java中分类和实例对象。实例=对象
		MyObject obj=new MyObject();//该对象是共享对象 
		ThreadA a=new ThreadA(obj);
		a.setName("ThreadA");
		ThreadB b=new ThreadB(obj);
		b.setName("ThreadB");
		a.start();
		b.start();
	}

}
