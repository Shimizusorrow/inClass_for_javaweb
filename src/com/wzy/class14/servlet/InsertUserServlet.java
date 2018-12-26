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


@WebServlet(name = "InsertUserServlet",urlPatterns = "/InsertUserServlet")
public class InsertUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user=new User();
        user.setId(Integer.valueOf(request.getParameter("id")));
        user.setUsername(request.getParameter("name"));
        user.setPassword(request.getParameter("password"));
        user.setSex(request.getParameter("sex"));
        user.setAge(Integer.valueOf(request.getParameter("age")));
        user.setBirthday(Date.valueOf(request.getParameter("birthday")));
        UserDao userDao=new UserDao();
        if(userDao.insert(user)){
            response.getWriter().println("insert successs");
        }else{
            response.getWriter().println("insert fail");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
