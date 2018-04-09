package com.zpl.day04_3;

public class ThreadB extends Thread{


	private ITask task;

	public ThreadB(ITask task) {
		super();
		this.task = task;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		task.otherMethod();
	}

}
