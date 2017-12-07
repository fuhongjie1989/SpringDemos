package com.zpl.demo;

import java.util.List;

import org.apache.log4j.Logger;

public class Test {

	public static void main(String[] args) {

		final Logger logger = Logger.getLogger(Test.class);
		try {
			List a = null;
			System.out.println(a.size());
		} catch (Exception e) {
			logger.error("run error.", e);
		}
	}
}
