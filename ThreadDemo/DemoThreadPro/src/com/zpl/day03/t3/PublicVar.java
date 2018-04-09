package com.zpl.day03.t3;

import java.util.concurrent.TimeUnit;

/**
 * ��������д���ʵ������ʱ���ܻ���ɡ����������
 * 
 * @author zhangpengliang
 *
 */
public class PublicVar {

	public String username = "A";
	public String password = "AA";

	public synchronized void setValue(String username, String password) {
		this.username = username;
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.password = password;
		System.out.println("setValue method thread name=" + Thread.currentThread().getName() + "username=" + username
				+ " password=" + password);
	}

	/**
	 * ��getValue����û�б�synchronized�ؼ�������ʱ,�ͻ�������<br>
	 * ԭ��:A�̵߳���setValue������ȡ������,��B�̵߳���getValue������Ҫ�������첽ִ��,��ʱ���ȡ��������ڴ��������Ϣʱ�� <br>
	 * ���ܴ�����set��get��ͻ��,������
	 */
	public synchronized void getValue() {
		System.out.println("getValue method thread name=" + Thread.currentThread().getName() + " username=" + username
				+ " password=" + password);
	}

}
