package com.zpl.day04_2;

public class TaskRun {

	public static void main(String[] args) {
		//Task1 task=new Task1();
		Task2 task=new Task2();
		ThreadA a=new ThreadA(task);
		a.setName("A");
		ThreadB b=new ThreadB(task);
		b.setName("B");
		a.start();
		b.start();
		
	}
}
