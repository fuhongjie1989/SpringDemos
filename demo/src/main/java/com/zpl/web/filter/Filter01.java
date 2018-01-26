package com.zpl.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.jboss.netty.util.internal.StringUtil;

import com.zpl.context.ThreadLocalContext;
import com.zpl.context.intf.User;
import com.zpl.logs.LogUtil;
import com.zpl.util.request.RequestUtil;
import com.zpl.util.string.StrUtil;
import com.zpl.uuid.UniqueSeq;

public class Filter01 implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//设置请求和响应编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//获取当前时间
		long startTime = System.currentTimeMillis();
		ThreadLocalContext.get().setThreadUUID(UniqueSeq.shortUUID());
		
		String url=RequestUtil.getServletPath(request);
		LogUtil.info("*****************"+url+"*****************************");
		LogUtil.info("调用开始[" + startTime + "][" + ThreadLocalContext.get().getThreadUUID() + "]");
		// 赋值当前请求的唯一标识
		LogUtil.info("线程[" + Thread.currentThread().getId() + "]=" + ThreadLocalContext.get().getThreadUUID());
		LogUtil.info("当前请求SessionID=[" + ((HttpServletRequest) request).getSession().getId() + "]");
		initThreadLocalUser(request);
		try {
			chain.doFilter(request, response);
		} catch ( Exception e) {
			LogUtil.error(e.toString());;
		}finally {
			LogUtil.debug("调用结束[^_^],本次请求用时："
					+ (System.currentTimeMillis() - startTime) / 1000.0000 + "秒[" + ThreadLocalContext.get().getThreadUUID() + "]");
		}
		
	}
	
	@SuppressWarnings("unused")
	private void initThreadLocalUser(ServletRequest request){
		String pk_id=StrUtil.trimStr(request.getParameter("pk_id"));
		User user=(User) ((HttpServletRequest)request).getSession().getAttribute("UserAuthority");
		if(user==null){
			user=new User();
			if(StrUtil.isNull(pk_id)){
				pk_id="LoginUser";
			}
			user.setAccuntId(pk_id);
			user.setId(pk_id);
			user.setSessionId(((HttpServletRequest)request).getSession().getId());
		}
		((HttpServletRequest)request).getSession().setAttribute("UserAuthority", user);
		ThreadLocalContext.get().setUser(user);
		String rqstType = StrUtil.trimStr(request.getParameter("rqstType"));// 请求类型AJAX/MOBILE/空
		ThreadLocalContext.get().setRequestType(rqstType);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
