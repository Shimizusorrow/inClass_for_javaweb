package com.wzy.javawebclass;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

@WebServlet(name = "GetResourcesServlet",urlPatterns = "/GetResourcesServlet")
public class GetResourcesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        ServletContext servletContext=this.getServletContext();
        PrintWriter out=response.getWriter();
        InputStream in= servletContext.getResourceAsStream("/WEB-INF/classes/resources/itcast.propertise");
        Properties pros=new Properties();
        pros.load(in);
        out.write(pros.getProperty("Address"));
        out.write(pros.getProperty("Company"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}