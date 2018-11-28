package com.wzy.class6;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RequestDispathcherIncludeServlet",urlPatterns = "/RequestDispathcherIncludeServlet")
public class RequestDispathcherIncludeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        RequestDispatcher  rd=request.getRequestDispatcher("/IncludedServlet?pl=abc");
        out.println("before including"+"<br>");
        rd.include(request,response);
        out.println("after including"+"<br>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
