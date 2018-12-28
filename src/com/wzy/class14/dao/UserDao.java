package com.wzy.class14.dao;

import com.wzy.class14.domain.User;
import com.wzy.class14.utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;

public class UserDao {
    public boolean insert(User user){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try{
            //获得数据的链接
            connection=JDBCUtils.getConnection();
            // 通过Connection对象获取Statement对象
            String sql="INSERT INTO users VALUES(?,?,?,?,?,?)";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,user.getId());
            preparedStatement.setString(2,user.getUsername());
            preparedStatement.setString(3,user.getPassword());
            preparedStatement.setString(4,user.getSex());
            preparedStatement.setInt(5,user.getAge());
            preparedStatement.setDate(6, (Date) user.getBirthday());
            int result=preparedStatement.executeUpdate();
            if(result>0){
                return true;
            }else
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.release(resultSet,preparedStatement,connection);
        }
        return false;
    }
    public boolean insertUser(User user){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try{
            //获得数据的链接
            connection=JDBCUtils.getConnection();
            // 通过Connection对象获取Statement对象
            String sql="INSERT INTO users VALUES(?,?,?)";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,user.getId());
            preparedStatement.setString(2,user.getUsername());
            preparedStatement.setString(3,user.getPassword());
            int result=preparedStatement.executeUpdate();
            if(result>0){
                return true;
            }else
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.release(resultSet,preparedStatement,connection);
        }
        return false;
    }
    public ArrayList<User>findAll(){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        ArrayList<User>list=new ArrayList<User>();
        try{
            connection=JDBCUtils.getConnection();
            String sql="SELECT * FROM users";
            preparedStatement=connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                User user=new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                user.setSex(resultSet.getString("sex"));
                user.setAge(resultSet.getInt("age"));
                user.setBirthday(resultSet.getDate("birthday"));
                list.add(user);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.release(resultSet,preparedStatement,connection);
        }
        return null;
    }
    public User findById(int id){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try{
            connection=JDBCUtils.getConnection();
            String sql="SELECT * FROM users Where id=?";
            preparedStatement=connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                User user=new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                user.setSex(resultSet.getString("sex"));
                user.setAge(resultSet.getInt("age"));
                user.setBirthday(resultSet.getDate("id"));
                return user;
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.release(resultSet,preparedStatement,connection);
        }
        return null;
    }
    public boolean deleteById(int id){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try{
            connection=JDBCUtils.getConnection();
            String sql="DELETE FROM users Where id=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            int result=preparedStatement.executeUpdate();
            if (result!=0){
                return true;
            }else
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.release(resultSet,preparedStatement,connection);
        }
        return false;
    }
    public boolean update(User user){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try{
            connection=JDBCUtils.getConnection();
            String sql="UPDATE users Set Name=?,password=?,sex=?,age=?,birthady=?where id=?";
            preparedStatement=connection.prepareStatement(sql);

            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,user.getId());
            preparedStatement.setString(2,user.getUsername());
            preparedStatement.setString(3,user.getPassword());
            preparedStatement.setString(4,user.getSex());
            preparedStatement.setInt(5,user.getAge());
            preparedStatement.setDate(6, (Date) user.getBirthday());
            int num=preparedStatement.executeUpdate();
            if(num>0)
                return true;
            return false;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.release(resultSet,preparedStatement,connection);
        }
        return false;
    }
}
