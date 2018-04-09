package com.zpl.day04_1;

public class Test {

	public static void main(String[] args) {
		SubMain sub=new SubMain();
		TreadA a=new TreadA(sub);
		a.setName("ThreadA");
		ThreadB b=new ThreadB(sub);
		b.setName("ThreadB");
		a.start();
		b.start();
		
	}

}
