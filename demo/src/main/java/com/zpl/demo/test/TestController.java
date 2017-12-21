package com.zpl.demo.test;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zpl.msg.ReturnMsg;
import com.zpl.web.BaseController;

@Controller
public class TestController extends BaseController {

	/**
	 * 显示测试页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("goTestPage.do")
	public ModelAndView getTestView(HttpServletRequest request,HttpServletResponse response){
		return return2page(response, "zpl/testview/testservice");
		
	}
	
	@RequestMapping("getJson.do")
	public ModelAndView getJsonInfo(HttpServletRequest request,HttpServletResponse response){
		ReturnMsg msg=new ReturnMsg();
		msg.setSuccess(true);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("A", "b");
		map.put("B", "h");
		map.put("C", "e");
		map.put("D", "t");
		map.put("E", "f");
		msg.setDatatable(map);
		return return2page(response, msg, null);
				
		
	}
}
