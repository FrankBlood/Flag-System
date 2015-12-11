/*use У�������̶ӹ�����Ϣϵͳ;
create table ��Ա(
id int AUTO_INCREMENT unique,
sid varchar(15) primary key,
sname varchar(50) not null,
sex varchar(5) check('��'or'Ů'),
age int,
height float,
weight float,
grade varchar(10),
college varchar(100),
dept varchar(100),
ave float
);*/
//package У�������̶ӹ�����Ϣϵͳ;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Member extends JFrame{
	
	JPanel Main;
	JPanel Other;
	JLabel lsid;
	JLabel lname;
	JLabel lsex;
	JLabel lage;
	JLabel lheight;
	JLabel lweight;
	JLabel lgrade;
	JLabel lcollege;
	JLabel ldept;
	JLabel lavg;
	JTextField tsid;
	JTextField tname;
	JTextField tsex;
	JTextField tage;
	JTextField theight;
	JTextField tweight;
	JTextField tgrade;
	JTextField tcollege;
	JTextField tdept;
	JTextField tavg;
	JButton OK;
	JButton Cancel;
	JLabel Hint;
	//JLabel nul;
	
	public Member() {
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
		Main.setLayout(new GridLayout(11,2));
	}
	
	public void label(){
		lsid=new JLabel("                                        "+"ѧ��");
		lname=new JLabel("                                        "+"����");
		lsex=new JLabel("                                        "+"�Ա�");
		lage=new JLabel("                                        "+"����");
		lheight=new JLabel("                                        "+"���");
		lweight=new JLabel("                                        "+"����");
		lgrade=new JLabel("                                        "+"�꼶");
		lcollege=new JLabel("                                        "+"ѧԺ");
		ldept=new JLabel("                                        "+"רҵ�༶");
		lavg=new JLabel("                                        "+"ƽ���ɼ�");
	}
	
	public void textfield(){
		Icon bug1=new ImageIcon("\1.gif");
		tsid=new JTextField(" ",20);
		tname=new JTextField("",20);
		tsex=new JTextField("",20);
		tage=new JTextField("",20);
		theight=new JTextField("",20);
		tweight=new JTextField("",20);
		tgrade=new JTextField("",20);
		tcollege=new JTextField("",20);
		tdept=new JTextField("",20);
		tavg=new JTextField("",20);
		OK=new JButton("ȷ���ύ");
		Cancel=new JButton("ɾ��");
		Hint=new JLabel("��Ա¼��Ҫ����Ŷ��",bug1,SwingConstants.LEFT);
		//nul=new JLabel("");
		OK.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				getConnection();
				//System.out.println("afdsfas");
				
			}
		});
		Cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				getCancel();
				//System.out.println("afdsfas");
				
			}
		});
	}
	
	public void addi(){
		Other.add(Hint);
		Main.add(lsid);
		Main.add(tsid);
		Main.add(lname);
		Main.add(tname);
		Main.add(lsex);
		Main.add(tsex);
		Main.add(lage);
		Main.add(tage);
		Main.add(lheight);
		Main.add(theight);
		Main.add(lweight);
		Main.add(tweight);
		Main.add(lgrade);
		Main.add(tgrade);
		Main.add(lcollege);
		Main.add(tcollege);
		Main.add(ldept);
		Main.add(tdept);
		Main.add(lavg);
		Main.add(tavg);
		Main.add(Cancel);
		Main.add(OK);
		setTitle("��Ա��Ϣ¼��");
		setResizable(false);
		setVisible(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://127.0.0.1:3306/У�������̶ӹ�����Ϣϵͳ";
			String user="root";
			String password="mysql123456";
			Connection conn=DriverManager.getConnection(url,user,password);
			Statement statement=conn.createStatement();
			String sid=tsid.getText();
			String name=tname.getText();
			String sex=tsex.getText();
			String age=tage.getText();
			String height=theight.getText();
			String weight=tweight.getText();
			String grade=tgrade.getText();
			String college=tcollege.getText();
			String dept=tdept.getText();
			String avg=tavg.getText();
			String updatesql="insert into ��Ա values(null,'"+sid+"','"+name+"','"+sex+"',"+age+","+height+","+weight+",'"+grade+"','"+college+"','"+dept+"',"+avg+")";
			statement.executeUpdate(updatesql);
			clear();
			statement.close();
			conn.close();
		}
		catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(Main, "ϵͳ�ļ�δ�ҵ�","������ʾ",JOptionPane.PLAIN_MESSAGE);
		}
		catch(SQLException e){
			clear();
			JOptionPane.showMessageDialog(Main, "��ʽ����������������","������ʾ",JOptionPane.PLAIN_MESSAGE);
		}		
	}
	
	public void getCancel(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://127.0.0.1:3306/У�������̶ӹ�����Ϣϵͳ";
			String user="root";
			String password="mysql123456";
			Connection conn=DriverManager.getConnection(url,user,password);
			Statement statement=conn.createStatement();
			String sid=tsid.getText();
			String Delete="delete from ��Ա where sid = '"+sid+"'";
			statement.executeUpdate(Delete);
			clear();
			statement.close();
			conn.close();
		}
		catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(Main, "ϵͳ�ļ�δ�ҵ�","������ʾ",JOptionPane.PLAIN_MESSAGE);
		}
		catch(SQLException e){
			clear();
			JOptionPane.showMessageDialog(Main, "��ʽ����������������","������ʾ",JOptionPane.PLAIN_MESSAGE);
		}		
	}
	
	public void clear(){
		tsid.setText("");
		tname.setText("");
		tsex.setText("");
		tage.setText("");
		theight.setText("");
		tweight.setText("");
		tgrade.setText("");
		tcollege.setText("");
		tdept.setText("");
		tavg.setText("");
	}

}

