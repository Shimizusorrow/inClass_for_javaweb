package com.wzy.class13;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "InsertDBServlet",urlPatterns = "/InsertDBServlet")
public class InsertDBServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //DB数据库之增删改查
        ResultSet resultSet = null;//存放数据库的存放结果集
        Connection connection = null;//用于连接数据库的
        PreparedStatement statement = null;//设置sql语句

        try {
            //1.注册数据库的
            Class.forName("com.mysql.jdbc.Driver");
            //2.通过DriverMannger获取数据库连接
            String url = "jdbc:mysql://localhost:3306/javawebclassdb1701";
            String username = "root";
            String password = "root";
            connection = DriverManager.getConnection(url, username, password);


            //3.通过Connection 对象获取Statement对象
            String sql = "INSERT INTO users(id,name,password,sex,age)VALUES(?,?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,2);
            statement.setString(2,"jsj");
            statement.setString(3,"00000");
            statement.setString(4,"女");
            statement.setInt(5,20);
            int result=statement.executeUpdate();
            if(result!=0){
                response.getWriter().println("Insert successs");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
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
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
