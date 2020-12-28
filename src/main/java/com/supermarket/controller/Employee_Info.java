package com.supermarket.controller;


import com.supermarket.dataobject.employee_InfoDO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Employee_Info {
    public String  cashier=null;

    public List<employee_InfoDO> employeeDeal(int id, String pas) throws Exception {
        List<employee_InfoDO> list=new ArrayList<employee_InfoDO>();
        ResultSet rs1=null;
        ResourceBundle resourceBundle=ResourceBundle.getBundle("application");
        Connection connection=null;
        PreparedStatement ps=null;
        try{
        String driver=resourceBundle.getString("driver");
        String url=resourceBundle.getString("url");
        String user=resourceBundle.getString("user");
        String password=resourceBundle.getString("password");

        Class.forName(driver);
        connection=DriverManager.getConnection(url,user,password);
        String sql="select *  from employee_info where employee_Id=? and employee_Password=?";
        ps=connection.prepareStatement(sql);
        ps.setInt(1,id);
        ps.setString(2,pas);

        rs1=ps.executeQuery();
            while(rs1.next()){
                int transid=rs1.getInt(1);
                String td=rs1.getString(2);
                String ca=rs1.getString(3);
                String ii=rs1.getString(4);
                Integer iname= rs1.getInt(5);
                String in=rs1.getString(6);
                String p   =rs1.getString(7);
                String s=rs1.getString(8);
                employee_InfoDO ee=new employee_InfoDO(transid,td,ca,ii,iname,in,p,s);
                list.add(ee);
            }
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
        return  list;
    }

    public String getCashier() {
        return cashier;
    }

    public void setCashier(String cashier) {
        this.cashier = cashier;
    }
}
