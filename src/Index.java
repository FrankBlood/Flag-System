//package 校国旗仪仗队管理信息系统;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class Index extends JFrame{
	
	JPanel Main;
	JPanel Other;
	JButton Insert;
	JButton Select;	JButton Borrow;
	JButton Return;
	JLabel Hint;
	
	//public Index(){}
	
	public Index() {
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		int screenHeight=screenSize.height;
		int screenWeight=screenSize.width;		
		setSize(screenWeight/2,screenHeight/2);
		setLocation(screenWeight/4,screenHeight/4);
		setLayout(new BorderLayout());
		Icon bug1=new ImageIcon("1.jpg");
		Main=new JPanel();
		Other=new JPanel();
		Other.setBackground(Color.red);
		Image icon = Toolkit.getDefaultToolkit().getImage("1.jpg");
		setIconImage(icon);
		/*ImageIcon background=new ImageIcon("国旗.jpeg");
		JLabel label=new JLabel(background);
		label.setBounds(0,0,background.getIconWidth(),background.getIconHeight());
		//Main.setOpaque(false);
		Main.add(label);*/
		add(Other,BorderLayout.NORTH);
		add(Main,BorderLayout.CENTER);
		Insert=new JButton("存入",bug1);
		Select=new JButton("查询");
		Borrow=new JButton("借");
		Return=new JButton("还");
		Hint=new JLabel("欢迎进入系统，请选择功能！",bug1,SwingConstants.LEFT);
		Insert.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				new InsertAll();
			}
		});
		Select.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				new SelectAll();
			}
		});
		Insert.setPreferredSize(new Dimension(100, 100));
		Select.setPreferredSize(new Dimension(100, 100));
		Borrow.setPreferredSize(new Dimension(100, 100));
		Return.setPreferredSize(new Dimension(100, 100));
		Other.add(Hint);
		Main.add(Insert);
		Main.add(Select);
		Main.add(Borrow);
		Main.add(Return);
		setTitle("校国旗仪仗队管理信息系统");
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		Index 主页=new Index();
	}

}
