package com.zpl.sso.cookie.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户用户验证门票
 * @author zhangpengliang
 *
 */
public class TicketServlet extends HttpServlet {
    private static final long serialVersionUID = 5964206637772848290L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ticket = request.getParameter("ticket");//门票
        //JVMCache是我们搞的一个很简单的缓存机制,也就是一个静态Map
        //String username = JVMCache.TICKET_AND_NAME.get(ticket);
        //JVMCache.TICKET_AND_NAME.remove(ticket);
        String username="cloud";
        PrintWriter writer = response.getWriter();
        writer.write(username);
    }

}