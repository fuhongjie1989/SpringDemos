package com.zpl.webservice.simple;

import javax.jws.WebService;

/**
 * webservice接口实现
 * @author zhangpengliang
 *
 */
@WebService
public class SayHelloImpl implements ISayHello {

	@Override
	public String say() {
		return "Hello,my name is zhangpengliang";
	}

	@Override
	public void write(String a) {
		System.out.println("I'm write "+ a);
	}

}
