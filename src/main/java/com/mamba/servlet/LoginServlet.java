package com.mamba.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author mamba
 * @create 2021-02-24
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取前端请求的参数
        String username = req.getParameter("username");


        if(username.equals("admin")){//登陆成功
            req.getSession().setAttribute("USER_SESSION",req.getSession().getId());

            resp.sendRedirect("/sys/success.jsp");
        }else{//登录失败
            resp.sendRedirect("/error.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
