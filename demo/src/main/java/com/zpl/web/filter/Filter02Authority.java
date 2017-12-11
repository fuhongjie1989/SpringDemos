package com.zpl.web.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.zpl.logs.LogUtil;
import com.zpl.msg.ReturnMsg;
import com.zpl.util.string.StrUtil;
import com.zpl.web.BaseController;
/**
 * 过滤判断登录权限
 * @author zhangpengliang
 *
 */
public class Filter02Authority implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String userSession=(String) ((HttpServletRequest)request).getSession().getAttribute("UserAuthority");
		String reqeustSession=((HttpServletRequest)request).getSession().getId();
		/**
		 * 为null说明用户信息不全
		 */
		if(userSession==null||StrUtil.isNull(userSession)){
			returnPage(request, response, "登录超时，请重新登录");
			return;
		}
		/**
		 * 如果session不一致说明不是同一个用户
		 */
		if (!reqeustSession.equals(userSession)) {
			returnPage(request, response, "登录用户与请求用户不符，请重新登录。");
			return;
		}
		try {
			// CacheManager.put(pk_uuid, user, 1800);
			chain.doFilter(request, response);
		} catch (Throwable e) {
			LogUtil.error(e.toString());
		}
		
	}
	
	private void returnPage(ServletRequest request, ServletResponse response, String returnMsg)
			throws ServletException, IOException {
		String rqstType = StrUtil.trimStr(request.getParameter("rqstType"));// 请求类型AJAX/MOBILE/空
		if (StrUtil.isNull(rqstType)) {
			//??
			request.getRequestDispatcher("runloginOut2.controller").forward(request, response);
			return;
		}
		ReturnMsg msg = new ReturnMsg();
		msg.setSuccess(false);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(BaseController.return2json(msg));
		out.flush();
		out.close();
		return;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
