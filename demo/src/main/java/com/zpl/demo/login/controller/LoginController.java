package com.zpl.demo.login.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zpl.demo.login.ILogin;
import com.zpl.demo.login.pojo.Role;
import com.zpl.excel.MyExcelView;
import com.zpl.msg.ReturnMsg;
import com.zpl.util.json.JSONUtil;
import com.zpl.uuid.UniqueSeq;
import com.zpl.web.BaseController;

/**
 * 登录controller
 * 
 * @author zhangpengliang
 *
 */

@Controller
public class LoginController extends BaseController {
	@Autowired
	private ILogin login;
	private static final Logger logger = LoggerFactory.getLogger("LoginController");

	@RequestMapping("login.do")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = this.getRequestMap(request);
		if (map.containsKey("logname") && map.containsKey("logpass")) {
			String name = (String) map.get("logname");
			String pass = (String) map.get("logpass");
			if (name.equals("admin")&&pass.equals("admin")&&name.equals(pass)) {
				try {
					return new ModelAndView("zpl/index");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				try {
					/*
					 * response.setContentType("application/json;charset=utf-8"); //
					 * 设置客户端ajax跨域请求通过通过 PrintWriter out = response.getWriter();
					 * String result=JSONUtil.formatJSONObject(map);
					 * System.out.println(result); out.print(result); return null;
					 */
					map.put("message", "提示：账号或密码错误");
					return new ModelAndView("zpl/login",map);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		map.put("message", "提示：账号或密码不能为空");
		return new ModelAndView("zpl/login", map);
	}

	@RequestMapping("index")
	public ModelAndView goIndex(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("/zpl/index");
	}

	@RequestMapping("login.do11")
	public void getLoginInfo(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = login.login("SAD_S0DQ37070517");
		System.out.println(map.get("TITLE"));
		logger.info((String) map.get("TITLE"));
		try {
			/**
			 * 往页面输出中文字符,乱码。以一下设置字符编码格式。不管用
			 */
			response.setCharacterEncoding("UTF-8");
			/**
			 * 往页面输出中文字符,乱码。以下设置字符编码格式。管用
			 */
			response.setContentType("text/html;charset=utf-8");
			PrintWriter writer = response.getWriter();
			writer.write(String.valueOf(map.get("TITLE")));
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping("loginOn.do")
	public ModelAndView loginOn(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		Map<String, Object> param = this.getRequestMap(request);
		ReturnMsg msg = new ReturnMsg();
		msg.getDatatable().put("A", "username");
		msg.getDatatable().put("B", "password");
		return return2page(response, msg, "index");
	}

	/**
	 * 将对象放到ModelMap中后,我们在jsp页面可以直接使用${roles.getRolecode()}获取
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("goTest.do")
	public String testview(ModelMap model) {
		Role r = new Role();
		r.setRolecode("ADMIN");
		r.setRolename("管理者");
		r.setRoleid(UniqueSeq.shortUUID());
		model.addAttribute("roles", r);
		return "zpl/testview/test";
	}

	/**
	 * 如果我们使用model/modelMap的addAttribute()方法,我们可以打断点查看它在栈中的table中的标识，<br>
	 * role的标识是role那么我们在页面就可以在jsp页面中使用${role.get方法}获取到值
	 * 
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("goTest01")
	public ModelAndView testview02(HttpServletResponse response, Model model) {
		Role r = new Role();
		r.setRolecode("ADMIN");
		r.setRolename("管理者");
		r.setRoleid(UniqueSeq.shortUUID());
		// model.addAttribute("roles", r);
		// 我们如果使用ReturnMsg返回一个json字符串，那么就没办法显示到jsp页面使用${}.
		ReturnMsg msg = new ReturnMsg();
		msg.getDatatable().put("roles", r);
		model.addAttribute(r);
		model.addAttribute("你好");
		return return2page(response, msg, "zpl/testview/test");
	}

	/**
	 * 这个请求中我们将数据封装成一个list放到了Model中<br>
	 * 我们在页面中的数据提取为${roleList.get(1).getRoleid()}
	 * 
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("goTest03")
	public ModelAndView testview03(HttpServletResponse response, Model model) {
		List<Role> list = new ArrayList<Role>();
		Role r = new Role();
		r.setRolecode("ADMIN");
		r.setRolename("管理者");
		r.setRoleid(UniqueSeq.shortUUID());
		Role r1 = new Role();
		r1.setRolecode("user");
		r1.setRolename("使用者");
		r1.setRoleid(UniqueSeq.shortUUID());
		list.add(r1);
		list.add(r);
		// model.addAttribute("roles", r);
		// 我们如果使用ReturnMsg返回一个json字符串，那么就没办法显示到jsp页面使用${}.
		ReturnMsg msg = new ReturnMsg();
		msg.getDatatable().put("roles", r);
		model.addAttribute(list);
		/**
		 * 下面这种model中的可以值为string，但是后面的会覆盖前面的
		 */
		model.addAttribute("你好");
		model.addAttribute("你buhao好");
		return return2page(response, msg, "zpl/testview/test");
	}

	@RequestMapping("goftl.do")
	public String testftl(ModelMap model) {
		Role r = new Role();
		r.setRolecode("ADMIN");
		r.setRolename("管理者");
		r.setRoleid(UniqueSeq.shortUUID());
		model.addAttribute("roles", r);
		return "testftl";
	}

	@RequestMapping("goftlList.do")
	public String testftllist(ModelMap model) {
		Role r = new Role();
		r.setRolecode("ADMIN");
		r.setRolename("管理者");
		r.setRoleid(UniqueSeq.shortUUID());

		Role r1 = new Role();
		r1.setRolecode("ADMIN");
		r1.setRolename("管理者");
		r1.setRoleid(UniqueSeq.shortUUID());
		List<Role> list = new ArrayList<Role>();
		list.add(r);
		list.add(r1);
		model.addAttribute("rList", list);// <#list rList as r>
		return "testftl";
	}

	/*****
	 * --------------------------Excel视图----------------------------------------
	 * ---------
	 *****/
	@RequestMapping("goExcel.do")
	public ModelAndView testExcel(Map model) {
		Role r = new Role();
		r.setRolecode("ADMIN");
		r.setRolename("管理者");
		r.setRoleid(UniqueSeq.shortUUID());

		Role r1 = new Role();
		r1.setRolecode("ADMIN");
		r1.setRolename("管理者");
		r1.setRoleid(UniqueSeq.shortUUID());
		List<Role> list = new ArrayList<Role>();
		list.add(r);
		list.add(r1);
		model.put("roles", list);// <#list rList as r>
		return new ModelAndView(new MyExcelView(), model);// 返回方式必须这么写，如果不这么写会去找对应的jsp文件
	}

	@RequestMapping("goPdf.do")
	public ModelAndView testPdf(Map model) {
		Role r = new Role();
		r.setRolecode("ADMIN");
		r.setRolename("管理者");
		r.setRoleid(UniqueSeq.shortUUID());

		Role r1 = new Role();
		r1.setRolecode("ADMIN");
		r1.setRolename("管理者");
		r1.setRoleid(UniqueSeq.shortUUID());
		List<Role> list = new ArrayList<Role>();
		list.add(r);
		list.add(r1);
		model.put("roles", list);// <#list rList as r>
		return new ModelAndView("", model);// 返回方式必须这么写，如果不这么写会去找对应的jsp文件
	}
}
