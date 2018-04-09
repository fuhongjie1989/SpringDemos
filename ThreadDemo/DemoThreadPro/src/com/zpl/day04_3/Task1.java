package com.zpl.day04_3;

public class Task1 implements ITask {

	@Override
	public void otherMethod() {
		System.out.println("--------------------------run otherMethod");
	}

	@Override
	public void dosomeTask() {
		synchronized(this){
			for(int i=0;i<1000;i++){
				System.out.println("当前线程为："+Thread.currentThread().getName()+" i="+i);
			}
		}
	}

}
