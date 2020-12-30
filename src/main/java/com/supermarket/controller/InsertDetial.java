package com.supermarket.controller;
import com.supermarket.VO.Login;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class InsertDetial {
    public String  cashier=null;

    public   void deal(String id,String name ,double num,double price) throws Exception {
        ResultSet rs1=null;
        ResourceBundle resourceBundle=ResourceBundle.getBundle("application");
        Connection connection=null;
        PreparedStatement ps=null,ps1=null;
        try{
            String driver=resourceBundle.getString("driver");
            String url=resourceBundle.getString("url");
            String user=resourceBundle.getString("user");
            String password=resourceBundle.getString("password");

            Class.forName(driver);
            connection=DriverManager.getConnection(url,user,password);
            //1.更新库存表 id,name,price:售价,num
            // 2.保存进货记录 参数：I_id,I_name,I_num,I_price
            String sql="insert into insert_storage (item_Id,item_Name,storage_number,storage_Date,price,employee_name) values(?,?,?,?,?,?)";
            String sql2="insert into item_storage (item_Id,item_Name,storage_price,storage_num) values(?,?,?,?)" +
                    "on duplicate key update storage_num=storage_num+?";
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date=df.format(new Date());
            String e_name= Login.getKk();   //获取登录员工姓名
            ps=connection.prepareStatement(sql);
            ps.setString(1,id);
            ps.setString(2,name);
            ps.setDouble(3,num);
            ps.setString(4,date);
            ps.setDouble(5,price);
            ps.setString(6,e_name);
            ps.execute();
            ps1=connection.prepareStatement(sql2);
            ps1.setString(1,id);
            ps1.setString(2,name);
            ps1.setDouble(3,price);
            ps1.setDouble(4,num);
            ps1.setDouble(5,num);
            ps1.execute();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if(rs1!=null)try{
                rs1.close();
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
    }



    public String getCashier() {
        return cashier;
    }

    public void setCashier(String cashier) {
        this.cashier = cashier;
    }
}
