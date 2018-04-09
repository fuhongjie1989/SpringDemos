package com.zpl.day01;

import java.util.concurrent.TimeUnit;

public class ThreadState {

	public static void main(String[] args) {
		new Thread(new TimeWaiting(), "TimeWaitingThread").start();
		new Thread(new Waiting(),"WaitThread").start();
		/**
		 * 下面两个线程有一个是阻塞的一个是time_waiting状态
		 * 
		 * <br>可以通过jps命令查看，找到ThreadState对应的pid号，然后执行jstack pid查看状态
		 */
		new Thread(new Blocked(), "BlockedThread-1").start();
		new Thread(new Blocked(), "BlockedThread-2").start();
		
		
	}
	
	static class TimeWaiting implements Runnable{

		@Override
		public void run() {
			while(true){
				try {
					//TimeUnit是java.util.concurrent包下面的一个类，表示给定单元粒度的时间段
					TimeUnit.SECONDS.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	/**
	 * 等待
	 * @author zhangpengliang
	 *
	 */
	static class Waiting implements Runnable{

		@Override
		public void run() {
			while(true){
				synchronized (Waiting.class) {
					try {
						Waiting.class.wait();//处于等待状态
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
	}
	/**
	 * 阻塞
	 * @author zhangpengliang
	 *
	 */
	static class Blocked implements Runnable{

		@Override
		public void run() {
			synchronized (Blocked.class) {
				while(true){
					try {
						TimeUnit.SECONDS.sleep(2000);//处于TIME_Waiting状态
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
	}

}
