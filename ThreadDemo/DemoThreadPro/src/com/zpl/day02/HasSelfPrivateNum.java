package com.zpl.day02;

/**
 * 
 * @author zhangpengliang
 *
 */
public class HasSelfPrivateNum {
	// 如果是方法内部的私有变量，则不存在非线程安全问题，所得到的结果就是线程安全的了
	public void addI(String username) {
		int num = 0;//因为num是方法内部的变量,所以线程是安全的。
		if (username.equals("a")) {
			try {
				num = 100;
				System.out.println("a set over");
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			num=200;
			System.out.println("b set over");
		}
		System.out.println(username+" num="+num);
	}

}
