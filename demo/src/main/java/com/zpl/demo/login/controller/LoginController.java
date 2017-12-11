package com.zpl.demo.login.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zpl.demo.login.ILogin;
import com.zpl.msg.ReturnMsg;
import com.zpl.web.BaseController;

/**
 * 登录controller
 * @author zhangpengliang
 *
 */

@Controller
public class LoginController extends BaseController{
	@Autowired
	private ILogin login;
	private static final Logger logger=LoggerFactory.getLogger("LoginController");
	
	@RequestMapping("login.do")
	public void getLoginInfo(HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> map=login.login("SAD_S0DQ37070517");
		System.out.println(map.get("TITLE"));
		logger.info((String)map.get("TITLE"));
		try {
			/**
			 * 往页面输出中文字符,乱码。以一下设置字符编码格式。不管用
			 */
			response.setCharacterEncoding("UTF-8");
			/**
			 * 往页面输出中文字符,乱码。以下设置字符编码格式。管用
			 */
			response.setContentType("text/html;charset=utf-8");
			PrintWriter writer=response.getWriter();
			writer.write(String.valueOf(map.get("TITLE")));
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping("loginOn")
	public ModelAndView loginOn(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		Map<String, Object> param=this.getRequestMap(request);
		ReturnMsg msg=new ReturnMsg();
		msg.getDatatable().put("A", "username");
		msg.getDatatable().put("B", "password");
		return return2page(response,msg, "index");
	}
}
