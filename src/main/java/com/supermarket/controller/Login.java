package com.supermarket.controller;

import com.supermarket.dataobject.employee_InfoDO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Login extends JFrame implements ActionListener {
	public static String kk;  //empolyeeName
	//定义窗口中存在的控件
	JLabel userLa,passLa,welcomeLa,name_La;
	JTextField userTxt;
	JPasswordField passTxt;
	JButton loBt,quitBt,sellBt,detialBt,stockBt;
	private DefaultTableModel model = null;
	private JTable table = null;
	private JButton addBtn = null;
	public Login()
	{
		this.setSize(500, 300);
		this.setLayout(null);
		//设置窗体的布局对象为空
		userLa=new JLabel("用户名");//创建标签
		userLa.setSize(60, 30);
		userLa.setLocation(90, 50);
		this.add(userLa);//将标签放到窗体上

		userTxt=new JTextField();//创建文本框
		userTxt.setSize(150, 30);
		userTxt.setLocation(160, 50);
		this.add(userTxt);//将文本框放到窗体上

		passLa=new JLabel("密   码");//创建标签
		passLa.setSize(60, 30);
		passLa.setLocation(90, 100);
		this.add(passLa);//将标签放到窗体上
		passTxt=new JPasswordField();//创建密码框
		passTxt.setSize(150, 30);
		passTxt.setLocation(160, 100);
		this.add(passTxt);//将密码框放到窗体上

		loBt=new JButton("登录");//创建按钮
		loBt.setSize(60, 30);
		loBt.setLocation(120, 150);
		loBt.addActionListener(this);
		this.add(loBt);//将按钮放到窗体上
		quitBt=new JButton("注册");//创建按钮
		quitBt.setSize(60, 30);
		quitBt.setLocation(210, 150);
		quitBt.addActionListener(this);
		this.add(quitBt);//将按钮放到窗体上*/

		this.setVisible(true);//设置窗体可见
	}

	public void actionPerformed(ActionEvent e)
	{
		JButton bt=(JButton)e.getSource();
		if(bt.getText().equals("登录"))
		{
			//获取用户输入的用户名和密码
			 int userName= Integer.parseInt(userTxt.getText().trim());
			String pass=passTxt.getText().trim();
			//调用员工文件处理类来进行验证
			Employee_Info deal=new Employee_Info();
			try {
				List<employee_InfoDO> list1=new ArrayList<employee_InfoDO>();
				list1= deal.employeeDeal(userName,pass);
				for(employee_InfoDO Item : list1){
					kk=Item.getEmployeeName();
				}
				if(kk!=null) {      //登录验证成功
					initMainFrame();
				}
				else { 	        //登录失败！！！
					userTxt.setText("");
					passTxt.setText("");
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		else if(bt.getText().equals("注册"))
		{
			new Logup();
		}
	}

	public void initMainFrame()
	{
		this.setSize(1000, 800);
		this.setTitle("主窗口");
		this.getContentPane().removeAll();
		//添加界面的控件

		welcomeLa=new JLabel("欢迎您！");//创建标签
		welcomeLa.setSize(80, 60);
		welcomeLa.setLocation(60, 20);
		this.add(welcomeLa);//将标签放到窗体上
		name_La=new JLabel(kk);//创建标签
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
		quitBt=new JButton("退出登录");
		quitBt.setSize(100,30);
		quitBt.setLocation(30, 280);
		this.add(quitBt);

		//对进货管理按钮的监控
		stockBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				new InsertItem();
				Login.this.dispose();
			}
		});
		//对退出登录按钮的监控
		quitBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				Login.this.dispose();
				new Login();
			}
		});
		//对零售界面按钮的监控
		sellBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				new Sell();
				Login.this.dispose();
			}
		});
		this.setVisible(true);//设置窗体可见
	}

	public static String getKk() {
		return kk;
	}
}
