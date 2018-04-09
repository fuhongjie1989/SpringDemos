package com.zpl.day01;

import java.util.concurrent.TimeUnit;

public class ThreadState {

	public static void main(String[] args) {
		new Thread(new TimeWaiting(), "TimeWaitingThread").start();
		new Thread(new Waiting(),"WaitThread").start();
		/**
		 * ���������߳���һ����������һ����time_waiting״̬
		 * 
		 * <br>����ͨ��jps����鿴���ҵ�ThreadState��Ӧ��pid�ţ�Ȼ��ִ��jstack pid�鿴״̬
		 */
		new Thread(new Blocked(), "BlockedThread-1").start();
		new Thread(new Blocked(), "BlockedThread-2").start();
		
		
	}
	
	static class TimeWaiting implements Runnable{

		@Override
		public void run() {
			while(true){
				try {
					//TimeUnit��java.util.concurrent�������һ���࣬��ʾ������Ԫ���ȵ�ʱ���
					TimeUnit.SECONDS.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	/**
	 * �ȴ�
	 * @author zhangpengliang
	 *
	 */
	static class Waiting implements Runnable{

		@Override
		public void run() {
			while(true){
				synchronized (Waiting.class) {
					try {
						Waiting.class.wait();//���ڵȴ�״̬
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
	}
	/**
	 * ����
	 * @author zhangpengliang
	 *
	 */
	static class Blocked implements Runnable{

		@Override
		public void run() {
			synchronized (Blocked.class) {
				while(true){
					try {
						TimeUnit.SECONDS.sleep(2000);//����TIME_Waiting״̬
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
	}

}
