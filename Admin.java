package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin extends JFrame implements ActionListener {

   JButton Add_Employee,Add_Room,Add_Driver,Logout,Back;
    Admin(){

        Add_Employee = new JButton("Add Employee");
        Add_Employee.setBounds(250,200,200,30);
        Add_Employee.setBackground(Color.WHITE);
        Add_Employee.setForeground(Color.BLACK);
        Add_Employee.setFont(new Font("Tahoma",Font.BOLD,15));
        Add_Employee.addActionListener(this);
        add(Add_Employee);


        Add_Room = new JButton("Add Room");
        Add_Room.setBounds(250,350,200,30);
        Add_Room.setBackground(Color.WHITE);
        Add_Room.setForeground(Color.BLACK);
        Add_Room.setFont(new Font("Tahoma",Font.BOLD,15));
        Add_Room.addActionListener(this);
        add(Add_Room);


        Add_Driver = new JButton("Add Driver");
        Add_Driver.setBounds(250,500,200,30);
        Add_Driver.setBackground(Color.WHITE);
        Add_Driver.setForeground(Color.BLACK);
        Add_Driver.setFont(new Font("Tahoma",Font.BOLD,15));
        Add_Driver.addActionListener(this);
        add(Add_Driver);


        Logout = new JButton("Logout");
        Logout.setBounds(10,650,95,30);
        Logout.setBackground(Color.BLACK);
        Logout.setForeground(Color.WHITE);
        Logout.setFont(new Font("Tahoma",Font.BOLD,15));
        Logout.addActionListener(this);
        add(Logout);


        Back = new JButton("Back");
        Back.setBounds(110,650,95,30);
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        Back.setFont(new Font("Tahoma",Font.BOLD,15));
        Back.addActionListener(this);
        add(Back);

        ImageIcon l1=new ImageIcon(ClassLoader.getSystemResource("icon/employees.png"));
        Image l11=l1.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon imageIcon=new ImageIcon(l11);
        JLabel label=new JLabel(imageIcon);
        label.setBounds(70,130,120,120);
        add(label);

        ImageIcon l2=new ImageIcon(ClassLoader.getSystemResource("icon/room.png"));
        Image l22=l2.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(l22);
        JLabel label1=new JLabel(imageIcon1);
        label1.setBounds(70,280,120,120);
        add(label1);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/driver.png"));
        Image i11=i1.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon image=new ImageIcon(i11);
        JLabel label3=new JLabel(image);
        label3.setBounds(70,440,120,120);
        add(label3);

        ImageIcon i2=new ImageIcon(ClassLoader.getSystemResource("icon/login.gif"));
        Image i111= i2.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon image1=new ImageIcon(i111);
        JLabel label4=new JLabel(image1);
        label4.setBounds(930,250,300,300);
        add(label4);


        getContentPane().setBackground(new Color(3,45,48));
        setLayout(null);
        setSize(1950,1090);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Admin();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==Add_Employee){

            new AddEmployee();

        }
        else if(e.getSource()==Add_Room){

            new AddRoom();
        }
        else if(e.getSource()==Add_Driver){

            new addDriver();
        }
        else if(e.getSource()==Logout){
            System.exit(34);
        }
        else if(e.getSource()==Back){
            new Dashboard();
            setVisible(false);
        }


    }
}
