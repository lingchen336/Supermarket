package com.supermarket.controller;

import com.supermarket.dataobject.item_storageDO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.Date;
import java.util.List;


public class Sell extends JFrame {
    String onePrice,insertNum,I_ID,I_Name;  //单价，输入数量,ID,货物名
    int x=1;
    double itemStatics=0;
    JLabel userLa,sellsLa,allLa,allSells,yuanLa,numLa,priceLa,welcomeLa,nameLa;
    JTextField itemIDTxt,itemNameTxt,sellsTxt,numTxt,priceTxt;
    JButton sellBt=null,quitBt=null,registerBt=null,stockBt=null;
    // 默认表格模型
    private DefaultTableModel model = null;
    private JTable table = null;
    private JButton addBtn = null,addBtn1=null;
    String name=Login.getKk();
    public  Sell()
    {
        setSize(1000, 800);
        this.setLayout(null);
        //设置窗体的布局对象为空
        userLa=new JLabel("商品ID");//创建标签
        userLa.setSize(60, 30);
        userLa.setLocation(250, 30);
        this.add(userLa);//将标签放到窗体上

        itemIDTxt=new JTextField();//创建文本框
        itemIDTxt.setSize(150, 30);
        itemIDTxt.setLocation(310, 30);
        this.add(itemIDTxt);//将文本框放到窗体上

        userLa=new JLabel("商品名称");//创建标签
        userLa.setSize(60, 30);
        userLa.setLocation(490, 30);
        this.add(userLa);//将标签放到窗体上

        itemNameTxt=new JTextField();//创建文本框
        itemNameTxt.setSize(150, 30);
        itemNameTxt.setLocation(560, 30);
        this.add(itemNameTxt);//将文本框放到窗体上

        numLa=new JLabel("库存数量");//创建标签
        numLa.setSize(60, 30);
        numLa.setLocation(250, 150);
        this.add(numLa);//将标签放到窗体上
        priceLa=new JLabel("单价");//创建标签
        priceLa.setSize(60, 30);
        priceLa.setLocation(490, 150);
        this.add(priceLa);//将标签放到窗体上
        addBtn = new JButton("查询");
        addBtn.setSize(60, 30);
        addBtn.setLocation(800, 30);
        this.add(addBtn);

        addBtn1 = new JButton("确认售出");
        addBtn1.setSize(92, 30);
        addBtn1.setLocation(800, 360);
        this.add(addBtn1);

        sellsLa=new JLabel("销售数量");//创建标签
        sellsLa.setSize(120, 30);
        sellsLa.setLocation(490, 360);
        this.add(sellsLa);//将标签放到窗体上

        sellsTxt=new JTextField();//创建文本框
        sellsTxt.setSize(150, 30);
        sellsTxt.setLocation(560, 360);
        this.add(sellsTxt);//将文本框放到窗体上

        allLa=new JLabel("合计(人民币):");//创建标签
        allLa.setSize(80, 80);
        allLa.setLocation(490, 450);
        this.add(allLa);//将标签放到窗体上

        yuanLa=new JLabel("元");//创建标签
        yuanLa.setSize(120, 60);
        yuanLa.setLocation(750, 460);
        this.add(yuanLa);//将标签放到窗体上
        //用列表展示的方法（可用）
//        String[][] titles = {};
//        String[] datas = { "ID", "商品名称","库存","单价" };
//        model = new DefaultTableModel(titles, datas);
//        table = new JTable(model);
//        table.setSize(150, 30);
//        table.setLocation(2000, 200);
//        this.add(new JScrollPane(table));
        welcomeLa=new JLabel("欢迎您！");//创建标签
        welcomeLa.setSize(80, 60);
        welcomeLa.setLocation(60, 20);
        this.add(welcomeLa);//将标签放到窗体上
        nameLa=new JLabel(name);//创建标签
        nameLa.setSize(80, 60);
        nameLa.setLocation(60, 60);
        this.add(nameLa);//将标签放到窗体上
        sellBt=new JButton("零售界面");
        sellBt.setSize(100,30);
        sellBt.setLocation(30, 160);
        this.add(sellBt);
        stockBt=new JButton("进货管理");
        stockBt.setSize(100,30);
        stockBt.setLocation(30, 220);
        this.add(stockBt);
        registerBt=new JButton("人员注册");
        registerBt.setSize(100,30);
        registerBt.setLocation(30, 280);
        this.add(registerBt);
        quitBt=new JButton("退出登录");
        quitBt.setSize(100,30);
        quitBt.setLocation(30, 340);
        this.add(quitBt);
        //对查询按钮进行监控
        addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                String itemID=itemIDTxt.getText().trim();
                String itemName=itemNameTxt.getText().trim();
                Search_item search_item=new Search_item();
                List<item_storageDO>  list = null;
                try {
                    list = search_item.search(itemID,itemName);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                //拿到查询结果  item_storage表
                for(item_storageDO Item : list){   //遍历结果集，添加数据到窗口

                    Double storageNumber = Item.getStorageNumber();
                    onePrice=Item.getItemPrice().toString();     //onePrice==单价
                    I_ID=Item.getItemId();
                    I_Name=Item.getItemName();
                    JTextField txt=new JTextField();
                    txt.setText(String.valueOf(storageNumber));
                    txt.setSize(80,30);
                    txt.setLocation(310,150);
                    Sell.this.add(txt);//将标签放到窗体上
                    JTextField txt1=new JTextField();
                    txt1.setText(String.valueOf(onePrice));
                    txt1.setSize(80,30);
                    txt1.setLocation(560,150);
                    Sell.this.add(txt1);//将标签放到窗体上
                }
            }
        });
        //对确认售出按钮的监控
        addBtn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                Sell_item sell=new Sell_item();
                //计算statistics的值（总价）
                double a1=Double.parseDouble(onePrice);
                insertNum=sellsTxt.getText().trim();
                double a2= Double.parseDouble(insertNum);
                itemStatics=a1*a2;
                String statics=String.valueOf(itemStatics);  //总价
                double num=Double.parseDouble(insertNum);   //销售数量

                sell.sell_item(I_ID,I_Name,onePrice,statics,num);
                System.out.println(new Date().toString()+"第"+x+++"单！");
                String val=String.valueOf(itemStatics);

                JTextField txt=new JTextField();
                txt.setText(val);
                txt.setSize(80,60);
                txt.setLocation(570,460);
                Sell.this.add(txt);//将标签放到窗体上
            }
        });
        //对进货管理按钮的监控
        stockBt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                new InsertItem();
                Sell.this.dispose();
            }
        });
        //对退出登录按钮的监控
        quitBt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                Sell.this.dispose();
                new Login();
            }
        });
        //对零售界面按钮的监控
        sellBt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                new Sell();
                Sell.this.dispose();
            }
        });
        //对人员注册按钮的监控
        registerBt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                new Logup();
                Sell.this.dispose();
            }
        });
        setVisible(true);

    }

}