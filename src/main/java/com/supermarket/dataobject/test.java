package com.supermarket.dataobject;

import java.awt.Button;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import javax.swing.JFrame;
//public class test {
//    private static final LayoutManager GridLayout = null;
//    public static void main(String[] args) {
//        final JFrame fr =new JFrame("窗口bai1");
//        fr.setLayout(GridLayout);
//        fr.setBounds(100, 180, 400, 400);
//
//        Button b = new Button("登录");
//        b.setBounds(80, 80, 80, 80);
//        fr.add(b);
//        fr.setVisible(true);
//        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        b.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JFrame jf = new JFrame("窗口2");
//                jf.setSize(400, 400);
//                jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
//                fr.dispose();
//                jf.setVisible(true);
//            }
//        });
//    }
//}

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.*;


class areatext extends JFrame implements ActionListener {
    JTextArea txt1 = new JTextArea(7, 35);
    JTextField txt2 = new JTextField(35);
    JButton jbtn1 = new JButton("按钮1");
    JButton jbtn2 = new JButton("按钮2");
    String str = "窗外飘起蒙蒙细雨，\n 平添一夜寒意，" + "\n多少的思绪藏在心底，";
    areatext() {
        setSize(400, 300);
        setVisible(true);
        setTitle("文本组件演示");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        txt1.setText(str);
        add(txt1);
        add(txt2);
        add(jbtn1);
        add(jbtn2);
        validate();
        jbtn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String s = txt2.getText();
                txt1.append("\n" + s);
                txt2.setText("");
            }
        });
        jbtn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txt1.setText("");
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
public class test {
    public static void main(String args[]) {
        new areatext();
    }
}

