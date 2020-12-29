package com.supermarket.controller;

import com.supermarket.dataobject.item_storageDO;

import java.math.BigDecimal;
import java.sql.*;
import java.util.*;

public class Permission {
    //查询库存信息
    public boolean getPermission(String name) throws Exception{
        ResourceBundle resourceBundle=ResourceBundle.getBundle("application");
        Connection connection=null;
        PreparedStatement ps=null;
        boolean rs=false;
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
            rs=ps.execute();
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
        return rs;
    }
}
