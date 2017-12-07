package com.zpl.logs;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class LogUtil {
	static Logger logger = LogManager.getRootLogger();
	static List<String> excludeClass = new ArrayList<String>();
	static {
		excludeClass.add("Thread");
		excludeClass.add("Unknown Source");
		excludeClass.add("LogUtil");
		excludeClass.add("MySqlPackageCallback");
		excludeClass.add("JdbcTemplate");
		excludeClass.add("JdbcTemplateHandle");
		excludeClass.add("SysOptLog");
		excludeClass.add("Native Method");
		excludeClass.add("NativeMethodAccessorImpl");
		excludeClass.add("DelegatingMethodAccessorImpl");
		excludeClass.add("Method");
		excludeClass.add("AopUtils");
		excludeClass.add("ReflectiveMethodInvocation");
		excludeClass.add("DelegatingIntroductionInterceptor");
		excludeClass.add("JdkDynamicAopProxy");
		excludeClass.add("SqlLog");
		excludeClass.add("RequestLog");
	}
	public static void info(String message) {
		String msg = message + " [ " + callMethod()+" ]";
		logger.info(msg);
	}
	
	public static void debug(String message){
		String msg = message + "  [ " + callMethod()+" ]";
		logger.debug(msg);
	}
	
	public static void error(String message){
		String msg = message + " [ " + callMethod()+" ]";
		logger.error(msg);
	}
	/**
	 * 获取到调用的方法名和类名地址
	 * @return
	 */
	public static String callMethod() {
		//获取方法栈的轨迹信息
		StackTraceElement[] exception = Thread.currentThread().getStackTrace();
		String className = "";
		String[] classAttr = null;
		for (StackTraceElement ste : exception) {
			className = ste.toString();
			className = className.substring(className.indexOf("(") + 1, className.indexOf(")"));
			classAttr = className.split("\\.");
			if (!LogUtil.excludeClass.contains(classAttr[0])) {
				return className;
			}
		}
		return "";
	}
}
