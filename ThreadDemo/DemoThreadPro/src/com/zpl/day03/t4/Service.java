package com.zpl.day03.t4;

public class Service {

	public synchronized void service1(){
		System.out.println("begin start method service1");
		service2();
	}
	
	public synchronized void service2(){
		System.out.println("begin start method service2");
		service3();
	}
	
	synchronized public void service3(){
		System.out.println("begin start method service3");
	}
}
