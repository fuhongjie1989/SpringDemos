package com.zpl.day05_1.innerClass;

import com.zpl.day05_1.innerClass.PublicClass.privateClass;
import com.zpl.day05_1.innerClass.PublicStaticClass.privateStaticClass;

public class Test {

	public static void main(String[] args) {
		// 主要看内置类的调用方式
		PublicClass p = new PublicClass();
		p.setPassword("112");
		p.setUsername("张三");
		// TODO 内置类的创建实例方式
		privateClass privateClass = p.new privateClass();
		privateClass.setAddress("北京");
		privateClass.setAge("12");

		// TODO 静态内置类实现方式
		PublicStaticClass ps = new PublicStaticClass();
		ps.setPassword("112");
		ps.setUsername("李四");
		// --静态内置类创建实例方式
		privateStaticClass psc = new privateStaticClass();
		psc.setAddress("上海");
		psc.setAge("23");
	}

}
