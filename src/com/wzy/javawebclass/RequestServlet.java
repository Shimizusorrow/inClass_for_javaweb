package com.wzy.javawebclass;


import com.sun.deploy.net.HttpRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "RequestServlet",urlPatterns = "/RequestServlet")
public class RequestServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String name = request.getParameter("username");

        String password = request.getParameter("password");
        System.out.print("用户名： "+name);
        System.out.print("密码： "+password);
        String[] hobbys = request.getParameterValues("hobby");
        System.out.print("爱好:");

        for (int i=0;i<hobbys.length;i++){
            System.out.print(hobbys[i]+"，");
        }

        if(name.equals("jxx")&&password.equals("123456")){
            response.sendRedirect("index.html");
        }else{
            response.sendRedirect("error.html");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }


}

