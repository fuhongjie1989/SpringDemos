package com.zpl.sso.cookie.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * SSO登录验证服务
 * @author zhangpengliang
 *
 */
public class SSOLoginServlet extends HttpServlet {private static final long serialVersionUID = -3170191388656385924L;

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request, response);
}

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String service = request.getParameter("service");

    if ("cloud".equals(username) && "cloud".equals(password)) {
    	//如果用户信息验证通过,将用户信息放到cookie中
        Cookie cookie = new Cookie("sso", username);
        cookie.setPath("/");//这一步很重要,涉及到跨域
        response.addCookie(cookie);//添加到响应中
        //生成门票ticket，并将门票放到缓存中
        long time = System.currentTimeMillis();
        String timeString = username + time;
        //JVMCache.TICKET_AND_NAME.put(timeString, username);

        if (null != service) {
        	//返回给A/B登录系统,然后用于验证门票
            StringBuilder url = new StringBuilder();
            url.append(service);
            if (0 <= service.indexOf("?")) {
                url.append("&");
            } else {
                url.append("?");
            }
            url.append("ticket=").append(timeString);
            response.sendRedirect(url.toString());
        } else {
            response.sendRedirect("/sso/index.jsp");
        }
    } else {
        response.sendRedirect("/sso/index.jsp?service=" + service);
    }
}
}
