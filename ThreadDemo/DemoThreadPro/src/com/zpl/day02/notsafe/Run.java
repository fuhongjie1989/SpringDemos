package com.zpl.day02.notsafe;

public class Run {

	public static void main(String[] args) {
		HasSelfPrivateNum numref = new HasSelfPrivateNum();// ��������˵�ǹ���ʵ��
		ThreadA a = new ThreadA(numref);
		ThreadB b = new ThreadB(numref);
		a.start();
		b.start();

	}

}
