package com.zpl.day02.notsafe;

/**
 * 
 * @author zhangpengliang
 * 
 * ��ʱ�������̲߳���������ϵ,��b�ȶ�num���޸ĵ�ʱ�򣬲����Ѿ�ˢ�µ��ڴ����˴�ʱa�Ѿ��ߵ������Ĵ�ӡ�ǿ�
 * ���ͻ�ȥ�ڴ��ж�ȡ�ñ�����ֵ����ôֵ�ͻ���b���õ�ֵ
 *
 */
public class HasSelfPrivateNum {
	private int num = 0;//��ʱ��num�Ѿ����Ƿ����ڲ��ı����ˣ����߳��ǲ���ȫ�ġ�
	// ����Ƿ����ڲ���˽�б������򲻴��ڷ��̰߳�ȫ���⣬���õ��Ľ�������̰߳�ȫ����
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
