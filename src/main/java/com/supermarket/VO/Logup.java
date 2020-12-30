package com.supermarket.VO;
import com.supermarket.controller.LogupDeal;

import javax.swing.*;
import java.awt.event.*;

public class Logup extends JFrame {
    JLabel workLa,nameLa,sexLa,ageLa,idLa,phoneLa,welcomeLa,name_La;
    JTextField workTxt,nameTxt,sexTxt,ageTxt,idTxt,phoneTxt;
    JButton sellBt=null,quitBt=null,registerBt=null,stockBt=null;
    String kk= Login.getKk();
    // 默认表格模型
    private JButton addBtn = null;

    public  Logup()
    {
        setSize(500, 600);
        this.setLayout(null);

        idLa=new JLabel("员工信息注册");//创建标签
        idLa.setSize(150, 50);
        idLa.setLocation(180, 30);
        this.add(idLa);//将标签放到窗体上

        workLa=new JLabel("职位");//创建标签
        workLa.setSize(60, 30);
        workLa.setLocation(80, 100);
        this.add(workLa);//将标签放到窗体上

        workTxt=new JTextField();//创建文本框
        workTxt.setSize(150, 30);
        workTxt.setLocation(150, 100);
        this.add(workTxt);//将文本框放到窗体上

        nameLa=new JLabel("姓名");//创建标签
        nameLa.setSize(60, 30);
        nameLa.setLocation(80, 150);
        this.add(nameLa);//将标签放到窗体上

        nameTxt=new JTextField();//创建文本框
        nameTxt.setSize(150, 30);
        nameTxt.setLocation(150, 150);
        this.add(nameTxt);//将文本框放到窗体上

        sexLa=new JLabel("性别");//创建标签
        sexLa.setSize(60, 30);
        sexLa.setLocation(80, 200);
        this.add(sexLa);//将标签放到窗体上

        sexTxt=new JTextField();//创建文本框
        sexTxt.setSize(150, 30);
        sexTxt.setLocation(150, 200);
        this.add(sexTxt);//将文本框放到窗体上

        ageLa=new JLabel("年龄");//创建标签
        ageLa.setSize(60, 30);
        ageLa.setLocation(80, 250);
        this.add(ageLa);//将标签放到窗体上

        ageTxt=new JTextField();//创建文本框
        ageTxt.setSize(150, 30);
        ageTxt.setLocation(150, 250);
        this.add(ageTxt);//将文本框放到窗体上

        idLa=new JLabel("身份证号");//创建标签
        idLa.setSize(60, 30);
        idLa.setLocation(80, 300);
        this.add(idLa);//将标签放到窗体上

        idTxt=new JTextField();//创建文本框
        idTxt.setSize(150, 30);
        idTxt.setLocation(150, 300);
        this.add(idTxt);//将文本框放到窗体上

        phoneLa=new JLabel("电话号码");//创建标签
        phoneLa.setSize(60, 30);
        phoneLa.setLocation(80, 350);
        this.add(phoneLa);//将标签放到窗体上

        phoneTxt=new JTextField();//创建文本框
        phoneTxt.setSize(150, 30);
        phoneTxt.setLocation(150, 350);
        this.add(phoneTxt);//将文本框放到窗体上

        addBtn = new JButton("下一步");
        addBtn.setSize(90, 30);
        addBtn.setLocation(160, 420);
        this.add(addBtn);

        //对下一步按钮进行监控
        addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                String work=workTxt.getText().trim();
                String name=nameTxt.getText().trim();
                String sex=sexTxt.getText().trim();
                String age=ageTxt.getText().trim();
                String id=idTxt.getText().trim();
                String phone=phoneTxt.getText().trim();

                LogupDeal logupDeal=new LogupDeal();
                try {
                    logupDeal.logupDeal(work,name,sex,age,id,phone);   //调用logupDeal函数向数据库 employee表中插入员工信息
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                //根据姓名配置唯一ID与设置密码
                int employee_id = logupDeal.get_employee_Id(name);
                new LogupAccess(employee_id);
                Logup.this.dispose();


            }
        });

        setVisible(true);
    }

}