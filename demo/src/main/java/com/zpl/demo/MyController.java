package com.zpl.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	@RequestMapping("login")
	public String sayHello(){
		System.out.println("12345");
		return "张三";
	}
}
