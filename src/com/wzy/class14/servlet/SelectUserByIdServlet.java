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

@WebServlet(name = "SelectUserByIdServlet",urlPatterns = "/SelectUserByIdServlet")
public class SelectUserByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.valueOf(request.getParameter("id"));
        UserDao userDao=new UserDao();
        User user=userDao.findById(id);
        String jsonstr=JSON.toJSONString(user);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().print(jsonstr);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
