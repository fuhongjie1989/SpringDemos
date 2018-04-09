package com.zpl.jio;

public class Run {

	public static void main(String[] args) {
		MapContains m=new MapContains();
		Thread1 t1=new Thread1(m);
		MapContains m1=new MapContains();
		Thread2 t2=new Thread2(m);
		t1.start();
		t2.start();
		
	}
}
