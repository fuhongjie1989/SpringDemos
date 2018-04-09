package com.zpl.day04_2;

public class ObjectRun {

	public static void main(String[] args) {

		/**
		 * 这里证明了,不同线程调用同一个对象的不同synchronized(this)方法,同步执行
		 * 原因很简单,就是synchronized(this) 获取的锁对象就是当前对象
		 */
		ObjectService s=new ObjectService();//共享对象实例
		ThreadAService a=new ThreadAService(s);
		ThreadBService b=new ThreadBService(s);
		a.setName("A");
		b.setName("B");
		a.start();
		b.start();
	}

}
