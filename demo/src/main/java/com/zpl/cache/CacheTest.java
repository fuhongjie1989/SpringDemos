package com.zpl.cache;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CacheTest {

	public static void main(String[] args) {
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
	                new String[]{"classpath:spring-servlet.xml"});
		 context.start();
		 CacheManage.put("key", "明仔");
		 System.out.println(CacheManage.get("key"));
	}

}
