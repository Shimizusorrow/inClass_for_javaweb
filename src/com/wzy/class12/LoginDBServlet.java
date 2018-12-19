package com.wzy.class12;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "LoginDBServlet",urlPatterns = "/LoginDBServlet")
public class LoginDBServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultSet resultSet=null;//存放数据库的存放结果集
        Connection connection=null;//用于连接数据库的
        Statement statement=null;//设置sql语句

        try{
            //1.注册数据库的
            Class.forName("com.mysql.jdbc.Driver");
            //2.通过DriverMannger获取数据库连接
            String url="jdbc:mysql://localhost:3306/javawebclassdb1701";
            String username="root";
            String password="root";
            connection=DriverManager.getConnection(url,username,password);
            //初始化
            statement=connection.createStatement();

            //使用statement执行SQL语句
            String sql="Select * FROM users";
            resultSet=statement.executeQuery(sql);
            //操作ResultSet结果集
            System.out.println("id|name|password|sex|age");
            while (resultSet.next()){
                int sqlId=resultSet.getInt("id");//通过列名获取指定的
                String sqlName=resultSet.getString("name");
                String sqlSex=resultSet.getString("sex");
                String sqlPassword=resultSet.getString("password");
                int sqlAge=resultSet.getInt("age");
                System.out.println(sqlId+"|"+sqlName+"|"+sqlPassword+"|"+sqlSex+"|"+sqlAge);

            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(resultSet!=null){
                try {
                    resultSet.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
                resultSet=null;
            }
            if(statement!=null){
                try {
                    statement.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
                statement=null;
            }
            if(connection!=null){
                try {
                    connection.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
                connection=null;
            }

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
