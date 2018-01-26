package com.zpl.webservice.cxf;

import javax.jws.WebService;

import org.springframework.stereotype.Component;

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
