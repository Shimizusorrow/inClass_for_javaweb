package com.wzy.class14.servlet;

import com.wzy.class14.dao.UserDao;
import com.wzy.class14.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;


@WebServlet(name = "LoginDbServlet",urlPatterns = "/LoginDbServlet")
public class InsertUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.valueOf(request.getParameter("id"));
        UserDao userDao=new UserDao();
        User user=userDao.findById(id);
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        if(username.equals(user.getUsername)&&password.equals(user.getPassword)){
            response.sendRedirect("index.html");
        }else {
            response.sendRedirect("error.html");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
