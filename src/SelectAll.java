//package 校国旗仪仗队管理信息系统;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class SelectAll extends JFrame{
	
	JPanel Main;
	JPanel Other;
	JButton member;
	JButton clothes;
	JButton shoes;
	JButton hat;
	JButton rest;
	JButton borrow;
	JLabel Hint;
	
	public SelectAll() {
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		int screenHeight=screenSize.height;
		int screenWeight=screenSize.width;		
		setSize(screenWeight/2,screenHeight/2);
		setLocation(screenWeight/4,screenHeight/4);
		setLayout(new BorderLayout());
		Main=new JPanel();
		Other=new JPanel();
		//Main.setBackground(Color.red);
		Other.setBackground(Color.red);
		add(Other,BorderLayout.NORTH);
		add(Main,BorderLayout.CENTER);
		member=new JButton("查询队员");
		clothes=new JButton("查询军服");
		shoes=new JButton("查询军鞋");
		hat=new JButton("查询军帽");
		rest=new JButton("查询其他");
		borrow=new JButton("查询借还");
		Hint=new JLabel("只能选择一种哦");
		member.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				new Member();
			}
		});
		clothes.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				new Clothes();
			}
		});
		shoes.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				new Shoes();
			}
		});
		hat.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				new Hat();
			}
		});
		rest.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				new Rest();
			}
		});
		member.setPreferredSize(new Dimension(100, 100));
		clothes.setPreferredSize(new Dimension(100, 100));
		shoes.setPreferredSize(new Dimension(100, 100));
		hat.setPreferredSize(new Dimension(100, 100));
		rest.setPreferredSize(new Dimension(100, 100));
		borrow.setPreferredSize(new Dimension(100, 100));
		Other.add(Hint);
		Main.add(member);
		Main.add(clothes);
		Main.add(shoes);
		Main.add(hat);
		Main.add(rest);
		Main.add(borrow);
		setTitle("存入系统");
		setResizable(false);
		setVisible(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
