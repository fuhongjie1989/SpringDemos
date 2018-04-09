package com.zpl.day02.notsafe;

/**
 * 
 * @author zhangpengliang
 * 
 * 这时候，两条线程产生竞争关系,当b先对num做修改的时候，并且已经刷新到内存中了此时a已经走到了最后的打印那块
 * ，就会去内存中读取该变量的值，那么值就会是b设置的值
 *
 */
public class HasSelfPrivateNum {
	private int num = 0;//此时，num已经不是方法内部的变量了，故线程是不安全的。
	// 如果是方法内部的私有变量，则不存在非线程安全问题，所得到的结果就是线程安全的了
	public synchronized void addI(String username) {
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
