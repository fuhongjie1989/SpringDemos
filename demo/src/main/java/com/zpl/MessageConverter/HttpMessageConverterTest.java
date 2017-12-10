package com.zpl.MessageConverter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 请求消息转换器测试。<br>
 * 
 * 负责将htp请求消息转换成一个<T>类型对象。或者将<T>转换成响应 <br>
 * DispatcherServlet已经默认安转了AnnotationMethodHandlerAdapter作为实现类
 * 
 * @author zhangpengliang
 *
 */
@Controller
public class HttpMessageConverterTest {

	//TODO 如何使用HttpMessageConverter<T>将请求信息转化成处理犯法的入参中呢？
	//两种法子：1、@RequestBody/@ResponseBody对方法进行标注
	//2、使用HttpEntity<T>/ResponseEntity<T>作为方法的入参或者返回值
	@RequestMapping("requestbody")
	public void test01(@RequestBody String body){
		System.out.println(body);
	}
	
}
