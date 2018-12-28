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


@WebServlet(name = "RegisterInDbServlet",urlPatterns = "/RegisterInDbServlet")
public class InsertUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user=new User();
        user.setId(Integer.valueOf(request.getParameter("id")));
        user.setUsername(request.getParameter("rusername"));
        user.setPassword(request.getParameter("password"));
        UserDao userDao=new UserDao();
        if(userDao.insertUser(user)){
            response.sendRedirect("filterlogin.html");
        }else{
            response.sendRedirect("register.html");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
