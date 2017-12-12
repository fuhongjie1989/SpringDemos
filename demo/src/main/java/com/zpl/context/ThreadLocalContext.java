package com.zpl.context;

import com.zpl.context.intf.ContextPojo;
/**
 * ThreadLocal
 * @author zhangpengliang
 *
 */
public class ThreadLocalContext {

	private static final ThreadLocal<ContextPojo> threadLocal=new ThreadLocal<ContextPojo>();
	/**
	 * 获取到ThreadLocal给当前线程提供的独立变量副本的内容
	 * @return
	 */
	public static ContextPojo get() {
		if (threadLocal.get() == null)
			threadLocal.set(new ContextPojo());
		return threadLocal.get();
	}
	/**
	 * 将ThreadLocal产生的变量副本中的内容清除
	 */
	public static void remove() {
		threadLocal.remove();
	}
	
}
