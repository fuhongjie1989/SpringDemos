package com.zpl.sso.cookie.filter;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zpl.util.http.HttpClient;
/**
 * 子系统的过滤器
 * @author zhangpengliang
 *
 */
public class ASystemFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		HttpSession session = request.getSession();// 获取当前请求的session
		String username = (String) session.getAttribute("username");// 获取当前session里的当前用户
		String ticket = request.getParameter("ticket");
		String url = URLEncoder.encode(request.getRequestURL().toString(), "UTF-8");// 获取请求的链接

		if (null == username) {
			// 如果session里的用户为空，就判断链接中存不存在ticket==门票

			/**
			 * 这个ticket从本地cookie中获取,但我们访问B系统的时候,SSO的过滤器会从<br>
			 * 请求中的cookie中获取,不为空,则转发给B系统。如果这时有门票,所以我们可以去验证门票<br>
			 * 的有效性
			 */
			if (null != ticket && !"".equals(ticket)) {
				// 有门票，去sso认证中心验证门票是否有效
				HttpClient httpClient = HttpClient.getInstance();
				username = httpClient.sendHttpPost("http://localhost:8081/sso/ticket", "ticket=" + ticket);
				if (null != username && !"".equals(username)) {
					// 如果验证门票有效且获取到了用户名，那么就将当前session的用户名放进去，然后通过
					session.setAttribute("username", username);
					filterChain.doFilter(request, response);
				} else {
					// 如果门票无效，没有获取到有效用户名，就跳转到sso登录
					response.sendRedirect("http://localhost:8081/sso/index.jsp?service=" + url);
				}
			} else {
				// 没有带门票就需要去sso那块去登录验证
				response.sendRedirect("http://localhost:8081/sso/index.jsp?service=" + url);
			}
		} else {
			filterChain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}