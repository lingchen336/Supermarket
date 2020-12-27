package com.supermarket.controller;

import com.supermarket.dataobject.item_storageDO;
import com.supermarket.dataobject.transforDO;

import javax.print.attribute.standard.DocumentName;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Vector;


public class Sell extends JFrame {
    String onePrice,insertNum;  //单价，输入数量
    int x=1;
    double itemStatics=0;
    JLabel userLa,sellsLa,allLa,allSells,yuanLa;
    JTextField itemIDTxt,itemNameTxt,sellsTxt;
    // 默认表格模型
    private DefaultTableModel model = null;
    private JTable table = null;
    private JButton addBtn = null,addBtn1=null;

    public  Sell()
    {
        //设置窗体的布局对象为空
        userLa=new JLabel("商品ID");//创建标签
        userLa.setSize(60, 30);
        userLa.setLocation(90, 280);
        this.add(userLa);//将标签放到窗体上

        itemIDTxt=new JTextField();//创建文本框
        itemIDTxt.setSize(150, 30);
        itemIDTxt.setLocation(150, 280);
        this.add(itemIDTxt);//将文本框放到窗体上

        userLa=new JLabel("商品名称");//创建标签
        userLa.setSize(60, 30);
        userLa.setLocation(460, 280);
        this.add(userLa);//将标签放到窗体上

        itemNameTxt=new JTextField();//创建文本框
        itemNameTxt.setSize(150, 30);
        itemNameTxt.setLocation(530, 280);
        this.add(itemNameTxt);//将文本框放到窗体上

        addBtn = new JButton("查询");
        addBtn.setSize(60, 30);
        addBtn.setLocation(750, 280);
        this.add(addBtn);

        addBtn1 = new JButton("确认售出");
        addBtn1.setSize(92, 30);
        addBtn1.setLocation(750, 360);
        this.add(addBtn1);

        sellsLa=new JLabel("销售数量");//创建标签
        sellsLa.setSize(120, 30);
        sellsLa.setLocation(460, 360);
        this.add(sellsLa);//将标签放到窗体上

        sellsTxt=new JTextField();//创建文本框
        sellsTxt.setSize(150, 30);
        sellsTxt.setLocation(530, 360);
        this.add(sellsTxt);//将文本框放到窗体上

        allLa=new JLabel("合计(人民币):");//创建标签
        allLa.setSize(80, 80);
        allLa.setLocation(480, 450);
        this.add(allLa);//将标签放到窗体上

        yuanLa=new JLabel("元");//创建标签
        yuanLa.setSize(120, 60);
        yuanLa.setLocation(700, 460);
        this.add(yuanLa);//将标签放到窗体上

        String[][] titles = {};
        String[] datas = { "ID", "商品名称","库存","单价" };
        model = new DefaultTableModel(titles, datas);
        table = new JTable(model);
        table.setSize(150, 30);
        table.setLocation(2000, 200);
        this.add(new JScrollPane(table));

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
                for(item_storageDO Item : list){   //添加数据到窗口
                    model.addRow(new String[] {Item.getItemId().toString(),Item.getItemName().toString()
                            ,Item.getStorageNumber().toString(),Item.getItemPrice().toString()});
                    onePrice=Item.getItemPrice().toString();     //onePrice==单价
                }
            }
        });
        //对确认售出按钮的监控
        addBtn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                String  itemID= (String) ((Vector)model.getDataVector().elementAt(0)).elementAt(0);
                String itemName= (String) ((Vector)model.getDataVector().elementAt(0)).elementAt(1);
                String itemPrice= (String) ((Vector)model.getDataVector().elementAt(0)).elementAt(3);
                Sell_item sell=new Sell_item();
                //计算statistics的值（总价）
                double a1=Double.parseDouble(onePrice);
                insertNum=sellsTxt.getText().trim();
                double a2= Double.parseDouble(insertNum);
                itemStatics=a1*a2;
                String statics=String.valueOf(itemStatics);  //总价
                double num=Double.parseDouble(insertNum);   //销售数量
                sell.sell_item(itemID,itemName,itemPrice,statics,num);
                System.out.println(new Date().toString()+"第"+x+++"单！");
                String val=String.valueOf(itemStatics);

                JTextField txt=new JTextField();
                txt.setText(val);
                txt.setSize(80,60);
                txt.setLocation(570,460);
                Sell.this.add(txt);//将标签放到窗体上
            }
        });
        setSize(1000, 800);
        setVisible(true);

    }

}