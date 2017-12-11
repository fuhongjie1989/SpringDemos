package com.zpl.sysController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zpl.msg.MsgInfo;
import com.zpl.msg.ReturnMsg;
import com.zpl.web.BaseController;
@Controller
public class OutTimerErrorController extends BaseController{
	@RequestMapping("runloginOut2.controller")
	public ModelAndView errorPage(HttpServletRequest request,HttpServletResponse response){
		ReturnMsg msg=new ReturnMsg();
		msg.setSuccess(false);
		MsgInfo msgInfo=new MsgInfo("errorinfo","登录超时,请重新登录");
		msg.addError(msgInfo);
		return return2page(response,msg, "zpl/sys/error/error");
	}
}
