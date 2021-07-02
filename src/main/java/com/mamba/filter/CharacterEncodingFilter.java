package com.mamba.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author mamba
 * @create 2021-02-23
 */
public class CharacterEncodingFilter implements Filter {

    //初始化：web服务器启动，就已经初始化了，随时等待过滤对象
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("CharacterEncodingFilter初始化");
    }

    @Override
    //chain:链的意思
    //1.过滤器中的所有代码，在过滤特定请求的时候都会执行，
    //2.必须要让过滤器继续同行
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        System.out.println("CharacterEncodingFilter 执行前");

        //让我们的程序继续走，如果不写，程序到这里就被拦截了
        chain.doFilter(request,response);

        System.out.println("CharacterEncodingFilter 执行后");
    }
    //销毁:web服务器关闭的时候web服务器就会销毁
    @Override
    public void destroy() {
        System.out.println("CharacterEncodingFilter销毁");
    }
}
