package com.wzy.class9;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "CharacterFilter",urlPatterns = "/*")
public class CharacterFilter implements Filter {
    public void destroy() {
        System.out.println("过滤器销毁");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request=(HttpServletRequest) req;
        HttpServletResponse response=(HttpServletResponse)resp;

       System.out.println("已经汉化");
//        request.setCharacterEncoding("utf-8");//只对post请求有效
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("filterdata","Filter Test");
//        response.setHeader("content-type","text/html;charset=UTF-8");

        chain.doFilter(request, response);
        System.out.println("汉化完毕");
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("过滤器初始化");
    }

}
