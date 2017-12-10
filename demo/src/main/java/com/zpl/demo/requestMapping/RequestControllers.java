package com.zpl.demo.requestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class RequestControllers {

	/**
	 * @ ReqeustMapping有参数
	 * <p>
	 * value method params 以及 headers<br>
	 * 分别表示请求的URL、请求方法、请求参数和报文头的映射条件，他们之间的关系联合使用多个条件<br>
	 * 可以让请求映射更加精确化。以下面为例子： <br>
	 * 请求链接为/user/delete<br>
	 * 但是请求必须为GET方式而且参数中必须有userId参数标识。
	 * 
	 * @param userid
	 */

	@RequestMapping(value = "/delete", method = RequestMethod.GET, params = "userId")
	public void test1(String userid) {
		System.out.println("get it ");
	}

	/****
	 * --------------------请求处理方法的签名概述-----------------------------------
	 *****/
	// TODO 一般情况下，处理方法返回的值类型为ModelAndView或String,前者包含模型和逻辑视图，后者仅仅代表一个逻辑视图

	// 1、@reqeustParam 绑定请求参数
	@RequestMapping("/requestparam")
	public void test2(@RequestParam("abc") String name, String age) {
		// @requestparam 中有三个属性，value参数名required是否必须，默认是true
		// defaultvalue 默认值，不推荐使用这个属性，因为用了以后required属性就自动设置为了false
		System.out.println("my name is :" + name);
	}

	// 2、@cookieVlaue 用于绑定请求中的Cookie值--用法和@RequestParam一样
	// 3、@RequestHeader 用于绑定请求报文头的属性值--用法和@RequestParam一样

	/**
	 * ------------------------下面是我们最常用的：使用Servlet
	 * API作为入参-----------------------
	 */

	// 如：
	@RequestMapping("/test3")
	public void test3(HttpServletRequest request, HttpServletResponse response) {
		// 同时使用httpServletRequet和HttpServletResponse 作为入参
	}

	@RequestMapping("/test4")
	public ModelAndView test4(HttpServletRequest request) {
		// 仅仅使用HttpServletRequest作为入参
		return new ModelAndView();
	}

	@RequestMapping("/test5")
	public ModelAndView test5(HttpSession Session) {
		// 仅仅使用HttpSession作为入参
		return new ModelAndView();
	}

	@RequestMapping("/test6")
	public String test6(HttpServletRequest request, @RequestParam("userName") String userName) {
		// 仅仅使用HttpServletRequest和基本类型参数作为入参
		return "abc";
	}
	// TODO----使用Servlet API作为入参时:会自动将web层对应的Servlet对象传递给处理方法的入参。
	
	//需要注意的是：处理方法自行使用HttpServletResponse返回响应的时候，则处理方法的返回值应该设置成void。----

}
