package com.zpl.day05_1;

/**
 * 从运行效果上来看都是同步的效果。<br>
 * 本质上：synchronized关键字加到static静态方法上是给<br>
 * Class类上锁
 * 
 * @author zhangpengliang
 *
 */
public class Run {

	public static void main(String[] args) {
		ThreadA A = new ThreadA();
		A.setName("A");
		ThreadB B = new ThreadB();
		B.setName("B");
		A.start();
		B.start();

	}

}
