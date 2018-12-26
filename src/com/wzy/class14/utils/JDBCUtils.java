package com.wzy.class14.utils;

import java.sql.*;

public class JDBCUtils {
    public static Connection getConnection()throws SQLException,
            ClassNotFoundException{
        //1.注册数据库驱动
        Class.forName("com.mysql.jdbc.Driver");

        String url="jdbc:mysql://localhost:3306/javawebclassdb1701";
        String username="root";
        String password="root";
        Connection connection=DriverManager.getConnection(url,username,password);
        return connection;
    }
    public static void release(ResultSet resultSet, Statement statement, Connection connection){
        if (statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            statement=null;
        }
        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            connection=null;
        }
        if (resultSet!=null){
            try{
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            resultSet=null;
        }
    }
}
