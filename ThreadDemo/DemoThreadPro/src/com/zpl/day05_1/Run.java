package com.zpl.day05_1;

/**
 * ������Ч������������ͬ����Ч����<br>
 * �����ϣ�synchronized�ؼ��ּӵ�static��̬�������Ǹ�<br>
 * Class������
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
