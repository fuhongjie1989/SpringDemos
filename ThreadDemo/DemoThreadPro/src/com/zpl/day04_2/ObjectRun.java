package com.zpl.day04_2;

public class ObjectRun {

	public static void main(String[] args) {

		/**
		 * ����֤����,��ͬ�̵߳���ͬһ������Ĳ�ͬsynchronized(this)����,ͬ��ִ��
		 * ԭ��ܼ�,����synchronized(this) ��ȡ����������ǵ�ǰ����
		 */
		ObjectService s=new ObjectService();//�������ʵ��
		ThreadAService a=new ThreadAService(s);
		ThreadBService b=new ThreadBService(s);
		a.setName("A");
		b.setName("B");
		a.start();
		b.start();
	}

}
