package com.zpl.day02;

/**
 * 
 * @author zhangpengliang
 *
 */
public class HasSelfPrivateNum {
	// ����Ƿ����ڲ���˽�б������򲻴��ڷ��̰߳�ȫ���⣬���õ��Ľ�������̰߳�ȫ����
	public void addI(String username) {
		int num = 0;//��Ϊnum�Ƿ����ڲ��ı���,�����߳��ǰ�ȫ�ġ�
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
