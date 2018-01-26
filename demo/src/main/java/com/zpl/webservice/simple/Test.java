package com.zpl.webservice.simple;

import javax.xml.ws.Endpoint;

public class Test {

	public static void main(String[] args) {
		//发布接口
		Endpoint.publish("http://localhost:8888/webservice/test", new SayHelloImpl());
	}

}
