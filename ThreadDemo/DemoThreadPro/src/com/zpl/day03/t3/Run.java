package com.zpl.day03.t3;

public class Run {
	public static void main(String[] args) {
		PublicVar var=new PublicVar();
		ThreadA a=new ThreadA(var);
		a.setName("ThreadA");
		a.start();
		var.getValue();
	}

}
