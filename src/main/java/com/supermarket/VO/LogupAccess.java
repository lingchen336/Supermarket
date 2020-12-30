package com.supermarket.VO;
import com.supermarket.controller.LogupDeal;

import javax.swing.*;
import java.awt.event.*;

public class LogupAccess extends JFrame {
    JLabel workLa,nameLa,sexLa,idLa;
    JTextField workTxt,nameTxt,sexTxt,ageTxt,idTxt,phoneTxt;
    JPasswordField pass1,pass2;
    // 默认表格模型
    private JButton addBtn = null,addBtn1=null;

    public  LogupAccess(final int id)
    {
        setSize(500, 600);
        this.setLayout(null);

        idLa=new JLabel("员工信息确认");//创建标签
        idLa.setSize(150, 50);
        idLa.setLocation(180, 30);
        this.add(idLa);//将标签放到窗体上

        workLa=new JLabel("您的ID号码为：");//创建标签
        workLa.setSize(100, 30);
        workLa.setLocation(80, 100);
        this.add(workLa);//将标签放到窗体上

        JTextField txt=new JTextField();
        txt.setText(String.valueOf(id));
        txt.setSize(150,30);
        txt.setLocation(200,100);
        this.add(txt);//将标签放到窗体上

        nameLa=new JLabel("请输入您的密码");//创建标签
        nameLa.setSize(100, 30);
        nameLa.setLocation(80, 150);
        this.add(nameLa);//将标签放到窗体上

        pass1=new JPasswordField();//创建文本框
        pass1.setSize(150, 30);
        pass1.setLocation(200, 150);
        this.add(pass1);//将文本框放到窗体上

        sexLa=new JLabel("请再输入一遍");//创建标签
        sexLa.setSize(100, 30);
        sexLa.setLocation(80, 200);
        this.add(sexLa);//将标签放到窗体上

        pass2=new JPasswordField();//创建文本框
        pass2.setSize(150, 30);
        pass2.setLocation(200, 200);
        this.add(pass2);//将文本框放到窗体上

        addBtn = new JButton("完成");
        addBtn.setSize(90, 30);
        addBtn.setLocation(260, 420);
        this.add(addBtn);

        addBtn1 = new JButton("上一步");
        addBtn1.setSize(90, 30);
        addBtn1.setLocation(130, 420);
        this.add(addBtn1);

        //对完成按钮进行监控
        addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                String p1=pass1.getText().trim();
                String p2=pass2.getText().trim();
                if(p1.equals(p2)){
                    //密码一致，向数据库表employee_info 插入密码
                    JOptionPane.showMessageDialog(LogupAccess.this, "注册成功");
                    LogupDeal logupDeal=new LogupDeal();
                    logupDeal.set_employee_password(id,p1);
                    //完成，返回登录页面
                    LogupAccess.this.dispose();
                    new Login();
                }else{   //密码不一致
                    pass1.setText("");
                    pass2.setText("");
                    JOptionPane.showMessageDialog(LogupAccess.this, "密码不一致");
                }
            }
        });
        //对上一步按钮进行监控
        addBtn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                //删除之前注册的不完整的信息，维护信息安全
                LogupDeal logupDeal=new LogupDeal();
                logupDeal.delete_employee_info(id);
                //返回上一个页面
                LogupAccess.this.dispose();
                Logup logup=new Logup();
            }
        });
        setVisible(true);
    }

}