package com.supermarket.controller;

import java.awt.Button;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
public class Test {
    private static final LayoutManager GridLayout = null;
    public static void main(String[] args) {
        final JFrame fr =new JFrame("窗口1");
        fr.setLayout(GridLayout);
        fr.setBounds(100, 180, 800, 800);
        Button b = new Button("登录");
        b.setBounds(80, 80, 160, 80);
        fr.add(b);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jf = new JFrame("窗口2");
                jf.setSize(400, 400);
                jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
                fr.dispose();
                jf.setVisible(true);
            }
        });
    }
}