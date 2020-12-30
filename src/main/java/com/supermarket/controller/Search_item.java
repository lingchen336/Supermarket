package com.supermarket.controller;

import com.supermarket.dataobject.item_storageDO;

import java.math.BigDecimal;
import java.sql.*;
import java.util.*;

public class Search_item {
    //查询库存信息
    public List<item_storageDO> search(String id,String name) throws Exception{
        List<item_storageDO> item_storageDOList=new ArrayList<item_storageDO>();
        ResourceBundle resourceBundle=ResourceBundle.getBundle("application");
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            //获取链接数据库
            String driver=resourceBundle.getString("driver");
            String url=resourceBundle.getString("url");
            String user=resourceBundle.getString("user");
            String password=resourceBundle.getString("password");
            /**
             * 1.注册驱动
             */
            Class.forName(driver);
            //2.获取连接
            connection= DriverManager.getConnection(url,user,password);
            //3.获取预编译的数据库操作对象
            String sql="select * from item_storage where item_Id =? or item_Name=?";
            ps= connection.prepareStatement(sql);
            ps.setString(1,id);
            ps.setString(2,name);
            //4.执行sql
            rs=ps.executeQuery();
            //5.处理结果集
            while(rs.next()){
                String item_id=rs.getString(1);
                String item_name=rs.getString(2);
                double item_price=rs.getDouble(3);
                double s_number=rs.getDouble(4);
                item_storageDO Ite=new item_storageDO(item_id,item_name,item_price,s_number);
                item_storageDOList.add(Ite);
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if(rs!=null)try{
                rs.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            if(ps!=null)try{
                ps.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            if(connection!=null)try{
                connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return item_storageDOList;
    }
    public String getPermission(String name) throws Exception{
        ResourceBundle resourceBundle=ResourceBundle.getBundle("application");
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String permission=null;
        try{
            //获取链接数据库
            String driver=resourceBundle.getString("driver");
            String url=resourceBundle.getString("url");
            String user=resourceBundle.getString("user");
            String password=resourceBundle.getString("password");
            /**
             * 1.注册驱动
             */
            Class.forName(driver);
            //2.获取连接
            connection= DriverManager.getConnection(url,user,password);
            //3.获取预编译的数据库操作对象
            String sql="select permission from employee_info where employee_Name=?";
            ps= connection.prepareStatement(sql);
            ps.setString(1,name);
            //4.执行sql
            rs=ps.executeQuery();
            while(rs.next()){
                permission=rs.getString(1);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if(ps!=null)try{
                ps.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            if(connection!=null)try{
                connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return permission;
    }
}
