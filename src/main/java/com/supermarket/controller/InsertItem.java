package com.supermarket.controller;

import com.supermarket.dataobject.item_storageDO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.supermarket.controller.Login.getKk;


public class InsertItem extends JFrame {
    double itemStatics=0;
    JLabel userLa,numLa,priceLa,welcomeLa,name_La;
    JTextField itemIDTxt,itemNameTxt,sellsTxt,numTxt,priceTxt;
    JButton sellBt=null,quitBt=null,registerBt=null,stockBt=null;
    // 默认表格模型
    private DefaultTableModel model = null;
    private JTable table = null;
    private JButton addBtn = null,addBtn1=null;
    String l_name= getKk();
    public  InsertItem()
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

        welcomeLa=new JLabel("欢迎您！");//创建标签
        welcomeLa.setSize(80, 60);
        welcomeLa.setLocation(60, 20);
        this.add(welcomeLa);//将标签放到窗体上
        name_La=new JLabel(l_name);//创建标签
        name_La.setSize(80, 60);
        name_La.setLocation(60, 60);
        this.add(name_La);//将标签放到窗体上
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
                SimpleDateFormat df=new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
                String date=df.format(new Date());
                System.out.println(date+" "+ getKk()+"进货"+name+num);
                JOptionPane.showMessageDialog(InsertItem.this, "进货成功");
            }
        });
        //对进货管理按钮的监控
        stockBt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                new InsertItem();
                InsertItem.this.dispose();
            }
        });
        //对退出登录按钮的监控
        quitBt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                InsertItem.this.dispose();
                new Login();
            }
        });
        //对零售界面按钮的监控
        sellBt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                new Sell();
                InsertItem.this.dispose();
            }
        });
        //对人员注册按钮的监控
        registerBt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                String b=null;
                Search_item search_item=new Search_item();
                try {
                    b = search_item.getPermission(getKk());
                    if(b.equals("0")) {
                        JOptionPane.showMessageDialog(InsertItem.this, "您没有权限");
                    };
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                if(b.equals("Y")){
                    new Logup();
                    InsertItem.this.dispose();
                }
            }
        });
        setVisible(true);

    }

}