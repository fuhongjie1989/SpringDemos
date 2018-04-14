package com.zpl.sso.cookie.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * SSO服务的过滤器
 * @author zhangpengliang
 *
 */
public class SSOFilter implements Filter {

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String service = request.getParameter("service");//请求服务的链接如A系统：http://ip:port/Alogin..
        String ticket = request.getParameter("ticket");//请求发过来的门票
        Cookie[] cookies = request.getCookies();//获取请求中的所有cooKie
        String username = "";
        //如果cookie不为空，那么遍历查询是否存在sso对应的cookie信息
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                if ("sso".equals(cookie.getName())) {
                    username = cookie.getValue();
                    break;
                }
            }
        }
        /**
         * 如果传过来没有带系统链接信息,但是带了门票,说明是用户验证门票的有效性
         */
        if (null == service && null != ticket) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        /**
         * 如果cookie中存在sso用户的相关信息,说明用户已经登录过,那我们可以直接将门票给用户。<br>
         * 再让用户来验证
         */
        if (null != username && !"".equals(username)) {
            long time = System.currentTimeMillis();
            String timeString = username + time;//为缓存生成一个key;相当于我们的门票
            //JVMCache.TICKET_AND_NAME.put(timeString, username);
            StringBuilder url = new StringBuilder();
            url.append(service);
            if (0 <= service.indexOf("?")) {
                url.append("&");
            } else {
                url.append("?");
            }
            url.append("ticket=").append(timeString);//构建好链接传送给登录的系统,如:A_url?ticket=门票值
            response.sendRedirect(url.toString());//转发过去。。。
        } else {
            filterChain.doFilter(servletRequest, servletResponse);//如果本地cookie没有相应的sso信息，那么直接通过跳转到登录界面
        }
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }

}