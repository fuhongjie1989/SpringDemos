package com.zpl.day05_1.innerClass;

import com.zpl.day05_1.innerClass.PublicClass.privateClass;
import com.zpl.day05_1.innerClass.PublicStaticClass.privateStaticClass;

public class Test {

	public static void main(String[] args) {
		// ��Ҫ��������ĵ��÷�ʽ
		PublicClass p = new PublicClass();
		p.setPassword("112");
		p.setUsername("����");
		// TODO ������Ĵ���ʵ����ʽ
		privateClass privateClass = p.new privateClass();
		privateClass.setAddress("����");
		privateClass.setAge("12");

		// TODO ��̬������ʵ�ַ�ʽ
		PublicStaticClass ps = new PublicStaticClass();
		ps.setPassword("112");
		ps.setUsername("����");
		// --��̬�����ഴ��ʵ����ʽ
		privateStaticClass psc = new privateStaticClass();
		psc.setAddress("�Ϻ�");
		psc.setAge("23");
	}

}
