package com.wzy.class８;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "IndexServlet",urlPatterns = "/IndexServlet")
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决乱码问题
        response.setContentType("text/html;charset=utf-8");
        //创建或者获取保存用户信息的Session对象
        HttpSession session=request.getSession();
        boolean isCheck=(boolean)session.getAttribute("ok");
        if(isCheck){
            response.getWriter().print("login successful");
        }else{
            response.sendRedirect("sessionlogin.html");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
