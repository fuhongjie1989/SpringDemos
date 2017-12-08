package com.zpl.dubbo;

import org.springframework.stereotype.Service;

@Service("demoService")
public class DubboProviderService implements IDubboProviderService {

	@Override
	public String sayHello(String str) {
		return "Hello "+str;
	}

}
