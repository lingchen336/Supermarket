package com.supermarket.controller;

import com.supermarket.dataobject.item_storageDO;
import com.supermarket.dataobject.transforDO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Vector;


public class Sell extends JFrame {
    JLabel userLa,passLa;
    JTextField itemIDTxt,itemNameTxt;
    JButton loBt,quitBt;
    // 默认表格模型
    private DefaultTableModel model = null;
    private JTable table = null;
    private JButton addBtn = null,addBtn1=null;

    public  Sell()
    {
        //设置窗体的布局对象为空
        userLa=new JLabel("商品ID");//创建标签
        userLa.setSize(60, 30);
        userLa.setLocation(90, 600);
        this.add(userLa);//将标签放到窗体上

        itemIDTxt=new JTextField();//创建文本框
        itemIDTxt.setSize(150, 30);
        itemIDTxt.setLocation(160, 600);
        this.add(itemIDTxt);//将文本框放到窗体上

        userLa=new JLabel("商品名称");//创建标签
        userLa.setSize(60, 30);
        userLa.setLocation(500, 600);
        this.add(userLa);//将标签放到窗体上

        itemNameTxt=new JTextField();//创建文本框
        itemNameTxt.setSize(150, 30);
        itemNameTxt.setLocation(570, 600);
        this.add(itemNameTxt);//将文本框放到窗体上

        addBtn = new JButton("查询");
        addBtn.setSize(60, 30);
        addBtn.setLocation(820, 600);
        this.add(addBtn);

        addBtn1 = new JButton("确认售出");
        addBtn1.setSize(120, 30);
        addBtn1.setLocation(820, 380);
        this.add(addBtn1);

        String[][] titles = {};
        String[] datas = { "ID", "商品名称","库存,","单价","销售数量","小计" };
        model = new DefaultTableModel(titles, datas);
        table = new JTable(model);
//        table.setRowMargin(1110);
        table.setSize(150, 30);
        table.setLocation(2000, 200);
        this.add(new JScrollPane(table));

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
                for(item_storageDO Item : list){
                    model.addRow(new String[] {Item.getItemId().toString(),Item.getItemName().toString()
                            ,Item.getStorageNumber().toString(),Item.getItemPrice().toString()});
                }
            }
        });
        addBtn1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                String  itemID= (String) ((Vector)model.getDataVector().elementAt(0)).elementAt(0);
                String itemName= (String) ((Vector)model.getDataVector().elementAt(0)).elementAt(1);
                String itemPrice= (String) ((Vector)model.getDataVector().elementAt(0)).elementAt(3);
                String itemNumber= (String) ((Vector)model.getDataVector().elementAt(0)).elementAt(4);
                String itemStatics= (String) ((Vector)model.getDataVector().elementAt(0)).elementAt(5);
                Sell_item sell=new Sell_item();
                sell.sell_item(itemID,itemName,itemPrice,itemNumber,itemStatics);
                System.out.println("nice!!!");
            }
        });

//        System.out.println(((Vector)model.getDataVector().elementAt(1)).elementAt(5));
        setSize(1000, 800);
//        setLocationRelativeTo(null);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);


    }

}