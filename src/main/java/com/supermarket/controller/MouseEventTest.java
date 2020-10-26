package com.supermarket.controller;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class MouseEventTest extends JFrame implements MouseListener{

	public JLabel label;
	public JButton button;
	
	public MouseEventTest()
	{
		this.setSize(300, 150);
		this.setTitle("鼠标事件实例");
		this.setLayout(null);
		label=new JLabel("标签");
		label.setSize(100,30);
		label.setLocation(30, 30);
		label.addMouseListener(this);
		this.add(label);
		button=new JButton("按钮");
		button.setSize(100,30);
		button.setLocation(30, 80);
		button.addMouseListener(this);
		this.add(button);
		this.setVisible(true);
	}
	
	 public void mouseClicked(MouseEvent e)
	 {}
	 public void mousePressed(MouseEvent e)
	 {}
	 public void mouseReleased(MouseEvent e)
	 {}
	 public void mouseEntered(MouseEvent e)
	 {
		 String type=e.getSource().getClass().toString();
		 //获取事件源的类型名
		 if(type.contains("JButton"))
		 {
			 JButton bt=(JButton)e.getSource();
			 bt.setText("鼠标进入");
		 }
		 else
		 {
			 JLabel la=(JLabel)e.getSource();
			 la.setText("鼠标进入");
		 }
	 }
	 
	 public void mouseExited(MouseEvent e)
	 {
		 String type=e.getSource().getClass().toString();
		 //获取事件源的类型名
		 if(type.contains("JButton"))
		 {
			 JButton bt=(JButton)e.getSource();
			 bt.setText("鼠标离开");
		 }
		 else
		 {
			 JLabel la=(JLabel)e.getSource();
			 la.setText("鼠标离开");
		 }
	 }
}
