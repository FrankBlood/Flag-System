/*use У�������̶ӹ�����Ϣϵͳ;
create table ��ñ(
id int AUTO_INCREMENT unique,
sid varchar(15) primary key,
sclass varchar(50) not null,
sex varchar(5) check('��'or'Ů'),
totle int,
rest int
);*/
//package У�������̶ӹ�����Ϣϵͳ;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class Hat extends JFrame{
	
	JPanel Main;
	JPanel Other;
	JLabel lid;
	JLabel lclass;
	JLabel lsex;
	JLabel ltotle;
	JLabel lrest;
	JTextField tid;
	JTextField tclass;
	JTextField tsex;
	JTextField ttotle;
	JTextField trest;
	JButton OK;
	JButton Cancel;
	JLabel Hint;
	//JLabel nul;

	public Hat() {
		init();
		label();
		textfield();
		addi();
	}
	public void init(){
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
		Main.setLayout(new GridLayout(6,2));
	}
	
	public void label(){
		lid=new JLabel("                                        "+"���");
		lclass=new JLabel("                                        "+"�ͺ�");
		lsex=new JLabel("                                        "+"�Ա�");
		ltotle=new JLabel("                                        "+"����");
		lrest=new JLabel("                                        "+"����");
	}
	
	public void textfield(){
		Icon bug1=new ImageIcon("\1.gif");
		tid=new JTextField(" ",20);
		tclass=new JTextField("",20);
		tsex=new JTextField("",20);
		ttotle=new JTextField("",20);
		trest=new JTextField("",20);
		OK=new JButton("ȷ���ύ");
		Cancel=new JButton("ɾ��");
		Hint=new JLabel("��ñ¼��Ҫ����Ŷ��",bug1,SwingConstants.LEFT);
		//nul=new JLabel("");
		OK.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				getConnection();//System.out.println("afdsfas");
			}
		});
	}
	
	public void addi(){
		Other.add(Hint);
		Main.add(lid);
		Main.add(tid);
		Main.add(lclass);
		Main.add(tclass);
		Main.add(lsex);
		Main.add(tsex);
		Main.add(ltotle);
		Main.add(ttotle);
		Main.add(lrest);
		Main.add(trest);
		//Main.add(nul);
		Main.add(Cancel);
		Main.add(OK);
		setTitle("��ñ��Ϣ¼��");
		setResizable(false);
		setVisible(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/У�������̶ӹ�����Ϣϵͳ";
			String user="root";
			String password="mysql123456";
			Connection conn=DriverManager.getConnection(url,user,password);
			Statement statement=conn.createStatement();
			String id=tid.getText();
			String sclass=tclass.getText();
			String sex=tsex.getText();
			String totle=ttotle.getText();
			String rest=trest.getText();
			String updatesql="insert into ��ñ values(null,'"+id+"','"+sclass+"','"+sex+"',"+totle+","+rest+")";
			statement.executeUpdate(updatesql);
			clear();
			statement.close();
			conn.close();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e){
			clear();
			JOptionPane.showMessageDialog(Main, "��ʽ����������������","������ʾ",JOptionPane.PLAIN_MESSAGE);
		}		
	}
	
	public void clear(){
		tid.setText("");
		tclass.setText("");
		tsex.setText("");
		ttotle.setText("");
		trest.setText("");
	}
	

}