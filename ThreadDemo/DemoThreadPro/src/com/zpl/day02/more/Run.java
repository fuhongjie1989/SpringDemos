package com.zpl.day02.more;

public class Run {
	public static void main(String[] args) {
		HasselfPrivateNums num1=new HasselfPrivateNums();
		HasselfPrivateNums num2=new HasselfPrivateNums();
		ThreadA a=new ThreadA(num1);
		ThreadB b=new ThreadB(num2);
		a.start();
		b.start();
	}
}
