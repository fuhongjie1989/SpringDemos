package com.zpl.day04_3;

public class Run {

	public static void main(String[] args) {
		ITask task=new Task2();
		ThreadA a=new ThreadA(task);
		ThreadB b=new ThreadB(task);
		a.setName("A");
		b.setName("B");
		a.start();
		b.start();
	}
}
