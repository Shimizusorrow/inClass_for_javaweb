package com.wzy.class13;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "DeleteDBServlet",urlPatterns = "/DeleteDBServlet")
public class DeleteDBServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PreparedStatement preparedStatement=null;
        Connection connection=null;
        ResultSet resultSet = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/javawebclassdb1701";
            String username = "root";
            String password = "root";

            connection = DriverManager.getConnection(url, username, password);
            String sql="DELETE FROM  users WHERE id=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,2);

            int result=preparedStatement.executeUpdate();
            if(result!=0){
                response.getWriter().println("Deletedate success");
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
            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
                preparedStatement=null;
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
        doPost(request, response);
    }
}
