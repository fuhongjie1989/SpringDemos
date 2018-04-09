package com.zpl.day02;

public class Run {

	public static void main(String[] args) {
		HasSelfPrivateNum numref = new HasSelfPrivateNum();//对下面来说是共享实例
		ThreadA a=new ThreadA(numref);
		ThreadB b=new ThreadB(numref);
		a.start();
		b.start();

	}

}
