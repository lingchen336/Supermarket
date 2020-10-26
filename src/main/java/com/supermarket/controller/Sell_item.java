package com.supermarket.controller;

import com.supermarket.dataobject.employee_InfoDO;
import com.supermarket.dataobject.transforDO;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class Sell_item {
    public void sell_item(String  itemID, String itemName,String itemPrice,String itemNumber,String itemStatics){
        String ss=Login.getKk();
        Employee_Info employee_info=new Employee_Info();

        ResourceBundle resourceBundle=ResourceBundle.getBundle("application");
        Connection connection=null;
        PreparedStatement ps1=null,ps2=null;
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Double bg1  = new Double(itemPrice);
        Double bg2  = new Double(itemStatics);
        try{
            String driver=resourceBundle.getString("driver");
            String url=resourceBundle.getString("url");
            String user=resourceBundle.getString("user");
            String password=resourceBundle.getString("password");
            Class.forName(driver);
            //2.获取连接
            connection= DriverManager.getConnection(url,user,password);
            //3.获取预编译的数据库操作对象
            String sql1="insert into transfor (trans_Date,cashier,item_Id,item_Name,trans_number,price,statistics) values(?,?,?,?,?,?,?)";
            String sql2="update storages set storage_number=storage_number-?";
            ps1= connection.prepareStatement(sql1);
            ps2= connection.prepareStatement(sql2);

            ps1.setString(1, String.valueOf(day));
            ps1.setString(2,ss );
            ps1.setString(3,itemID);
            ps1.setString(4,itemName);
            ps1.setInt(5, Integer.parseInt(itemNumber));
            ps1.setDouble(6, bg1);
            ps1.setDouble(7, bg2);

            ps2.setInt(1,Integer.parseInt(itemNumber));
            //4.执行sql
            ps1.execute();
            ps2.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(ps1!=null)try{
                ps1.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            if(connection!=null)try{
                connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
