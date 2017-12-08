package com.zpl.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zpl.dubbo.IDubboProviderService;

@Controller
public class DubboCustomerController {
	@Autowired
	private IDubboProviderService demoService;
	@RequestMapping("hello")
	public void say(String str){
		String s=demoService.sayHello("你个大撒比");
		System.out.println(s);
	}
}
