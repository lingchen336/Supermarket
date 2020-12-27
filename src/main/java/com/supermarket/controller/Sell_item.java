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
    //向transfor表插入销售详细信息
    //更新库存表item_storage的storage_num
    public void sell_item(String  itemID, String itemName,String itemPrice,String itemStatics,double num){
        String name=Login.getKk();   //获取登录员工姓名
        Employee_Info employee_info=new Employee_Info();

        ResourceBundle resourceBundle=ResourceBundle.getBundle("application");
        Connection connection=null;
        PreparedStatement ps1=null,ps2=null;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Double price  = new Double(itemPrice);
        Double statics  = new  Double(itemStatics);
        try{
            String driver=resourceBundle.getString("driver");
            String url=resourceBundle.getString("url");
            String user=resourceBundle.getString("user");
            String password=resourceBundle.getString("password");
            Class.forName(driver);
            //2.获取连接1
            connection= DriverManager.getConnection(url,user,password);
            //3.获取预编译的数据库操作对象
            String sql1="insert into transfor (trans_Id,trans_Date,cashier,item_Id,item_Name,trans_number,price,statistics) values(?,?,?,?,?,?,?,?)";
            String sql2="update item_storage set storage_num=storage_num-?";
            ps1= connection.prepareStatement(sql1);
            ps2= connection.prepareStatement(sql2);
            String date=df.format(new Date());
            ps1.setInt(1,0);
            ps1.setString(2, date);//系统当前时间
            ps1.setString(3,name );
            ps1.setString(4,itemID);
            ps1.setString(5,itemName);
            ps1.setDouble(6, num);
            ps1.setDouble(7, price);
            ps1.setDouble(8, statics);

            ps2.setDouble(1,num);
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
