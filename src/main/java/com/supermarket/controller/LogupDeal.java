package com.supermarket.controller;
import java.sql.*;
import java.util.ResourceBundle;

public class LogupDeal {
    public String  cashier=null;

    public void logupDeal(String work,String name,String sex,String age,String idCard,String phone) throws Exception {
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
            String sql="insert into employee_info (employee_Work,employee_Name,employee_Sex,employee_Age,employee_IdCard,employee_Phone) values(?,?,?,?,?,?)";
            ps=connection.prepareStatement(sql);
            ps.setString(1,work);
            ps.setString(2,name);
            ps.setString(3,sex);
            ps.setString(4,age);
            ps.setString(5,idCard);
            ps.setString(6,phone);
            ps.execute();
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
    public int get_employee_Id(String name){
        int id=0;
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
            String sql="select employee_Id from employee_info where employee_Name=?";
            ps=connection.prepareStatement(sql);
            ps.setString(1,name);
            rs1=ps.executeQuery();
            while (rs1.next()){
                id=rs1.getInt(1);
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
        return id;
    }
    public void set_employee_password(int id,String p1){
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
            String sql="update employee_info set employee_Password=? where employee_Id=?";
            ps=connection.prepareStatement(sql);
            ps.setString(1,p1);
            ps.setInt(2,id);
            ps.execute();
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
    public void delete_employee_info(int id){
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
            String sql="delete from employee_info where employee_Id=?";
            ps=connection.prepareStatement(sql);
            ps.setInt(1,id);
            ps.execute();
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
