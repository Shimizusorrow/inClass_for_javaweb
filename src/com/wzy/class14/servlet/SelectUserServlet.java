package com.wzy.class14.servlet;

import com.alibaba.fastjson.JSON;
import com.wzy.class14.dao.UserDao;
import com.wzy.class14.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SelectUserServlet",urlPatterns = "/SelectUserServlet")
public class SelectUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao=new UserDao();
        List<User> userList=userDao.findAll();
        String jsonstr=JSON.toJSONString(userList);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().print(jsonstr);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
