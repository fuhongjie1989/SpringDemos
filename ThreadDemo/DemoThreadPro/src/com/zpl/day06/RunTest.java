package com.zpl.day06;

import java.util.concurrent.TimeUnit;

/**
 * ��ֻ֤Ҫ���󲻱�,��ʹ��������Ըı���,���н������ͬ����
 * 
 * @author zhangpengliang
 *
 */
public class RunTest {

	static class UserInfo {
		private String username;
		private String password;

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

	}

	static class Service {
		public void serviceMethodA(UserInfo user) {
			// A�߳��Ѿ���user�����������޸�,���ǻ���ͬ���Ĵ�ӡ��־��˵�������ǵ���֤
			synchronized (user) {
				try {
					System.out.println(Thread.currentThread().getName()
							+ "��ʼ����ServiceMehtodA");
					user.setUsername("abcdddd");
					TimeUnit.SECONDS.sleep(2);
					System.out.println("����ʱ�䣺" + System.currentTimeMillis());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		Service service = new Service();
		UserInfo user = new UserInfo();
		ThreadA a = new ThreadA(service, user);
		ThreadB b = new ThreadB(service, user);
		a.setName("A");
		b.setName("B");
		a.start();
		b.start();
	}

	static class ThreadA extends Thread {
		private Service service;
		private UserInfo user;

		public ThreadA(Service service, UserInfo user) {
			super();
			this.service = service;
			this.user = user;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			service.serviceMethodA(user);
		}
	}

	static class ThreadB extends Thread {
		private Service service;
		private UserInfo user;

		public ThreadB(Service service, UserInfo user) {
			super();
			this.service = service;
			this.user = user;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			service.serviceMethodA(user);
		}
	}

}
