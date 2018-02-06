package com.zpl.threadpool;


import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.task.TaskExecutor;

public class Test {

	public static void main(String[] args) {
		//获取上下文
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("classpath*:spring-servlet.xml");
		//获取线程池的执行器
		TaskExecutor task=(TaskExecutor) context.getBean("taskExecutor");
		for (int i = 0; i < 10; i++) {
            SpringThread t = new SpringThread(i);
            task.execute(t);//放到线程池中处理
        }
	}
}
