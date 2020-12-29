package com.supermarket.controller;

import com.supermarket.dataobject.item_storageDO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.Date;
import java.util.List;


public class Transfor extends JFrame {
    String onePrice,insertNum,itemID,itemName;  //单价，输入数量,ID,货物名
    int x=1;
    double itemStatics=0;
    JLabel userLa,numLa,priceLa;
    JTextField itemIDTxt,itemNameTxt,sellsTxt,numTxt,priceTxt;
    JButton sellBt=null,quitBt=null,detialBt=null,stockBt=null;
    // 默认表格模型
    private DefaultTableModel model = null;
    private JTable table = null;
    private JButton addBtn = null,addBtn1=null;

    public  Transfor()
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

        numLa=new JLabel("入库数量");//创建标签
        numLa.setSize(60, 30);
        numLa.setLocation(250, 150);
        this.add(numLa);//将标签放到窗体上
        numTxt=new JTextField();//创建文本框
        numTxt.setSize(150, 30);
        numTxt.setLocation(310, 150);
        this.add(numTxt);//将文本框放到窗体上

        priceLa=new JLabel("单价");//创建标签
        priceLa.setSize(60, 30);
        priceLa.setLocation(490, 150);
        this.add(priceLa);//将标签放到窗体上
        priceTxt=new JTextField();//创建文本框
        priceTxt.setSize(150, 30);
        priceTxt.setLocation(560, 150);
        this.add(priceTxt);//将文本框放到窗体上

        addBtn1 = new JButton("确认进货");
        addBtn1.setSize(92, 30);
        addBtn1.setLocation(470, 360);
        this.add(addBtn1);

        sellBt=new JButton("零售界面");
        sellBt.setSize(100,30);
        sellBt.setLocation(30, 50);
        this.add(sellBt);
        stockBt=new JButton("进货管理");
        stockBt.setSize(100,30);
        stockBt.setLocation(30, 170);
        this.add(stockBt);
        quitBt=new JButton("退出登录");
        quitBt.setSize(100,30);
        quitBt.setLocation(30, 230);
        this.add(quitBt);

        //对确认进货按钮的监控
        //1.更新库存表 id,name,price:售价,num
        // 2.保存进货记录 参数：I_id,I_name,I_num,I_price
        addBtn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                String id=itemIDTxt.getText().trim();
                String name=itemNameTxt.getText().trim();
                double num=Double.parseDouble(numTxt.getText().trim());
                double price=Double.parseDouble(priceTxt.getText().trim());

                InsertDetial insertItem= new InsertDetial();
                try {
                    insertItem.deal(id,name,num,price);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }

            }
        });
        setVisible(true);

    }

}