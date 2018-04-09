
package com.zpl.day04_3;

public class ThreadA extends Thread{

	private ITask task;

	public ThreadA(ITask task) {
		super();
		this.task = task;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		task.dosomeTask();
	}
}
