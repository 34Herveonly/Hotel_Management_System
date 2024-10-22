package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login2 extends JFrame implements ActionListener {
    JTextField textField1;
    JPasswordField passwordField;
    JButton b1,b2 ;

    Login2(){
        JLabel label1=new JLabel("Username");
        label1.setBounds(40,20,100,30);
        label1.setFont(new Font("Arial",Font.BOLD,16));
        label1.setForeground(Color.WHITE);
        add(label1);

        JLabel label2=new JLabel("Password");
        label2.setBounds(40,70,100,30);
        label2.setFont(new Font("Arial",Font.BOLD,16));
        label2.setForeground(Color.WHITE);
        add(label2);

        textField1=new JTextField();
        textField1.setBounds(150,20,150,30);
        textField1.setForeground(Color.WHITE);
        textField1.setFont(new Font("Arial",Font.PLAIN,16));
        textField1.setBackground(new Color(26,104,110));
        add(textField1);

        passwordField=new JPasswordField();
        passwordField.setBounds(150,70,150,30);
        passwordField.setForeground(Color.WHITE);
        passwordField.setBackground(new Color(26,104,110));
        passwordField.setFont(new Font("Arial",Font.PLAIN,16));
        add(passwordField);

        ImageIcon icon=new ImageIcon(ClassLoader.getSystemResource("icon/login.gif"));
        Image i1= icon.getImage().getScaledInstance(255,300,Image.SCALE_DEFAULT);
        JLabel label3=new JLabel(icon);
        label3.setBounds(318,-30,255,300);
        add(label3);

        b1=new JButton("Login");
        b1.setBounds(40,140,120,30);
        b1.setFont(new Font("Arial",Font.BOLD,16));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Cancel");
        b2.setBounds(180,140,120,30);
        b2.setFont(new Font("Arial",Font.BOLD,16));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);


        getContentPane().setBackground(new Color(3,45,48));
        setLayout(null);
        setLocation(400,270);
        setSize(600,300);
        setTitle("Admin Login Screen");
        setVisible(true);
    }


    public static void main(String[] args) {

        new Login2();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){

            try {
                Connect connect=new Connect();
                String username=textField1.getText();
                String password=String.valueOf(passwordField.getPassword());

                String q="select * from login2 where user_name='"+username+"' and password='"+password+"'";
                ResultSet resultSet=connect.statement.executeQuery(q);

                if(resultSet.next()){
                    new Admin();
                    setVisible(false);

                }else {
                    JOptionPane.showMessageDialog(null,"Invalid Username or Password");
                }

            }catch (Exception exception){
                exception.printStackTrace();
            }


        }else {
            new Dashboard();
            setVisible(false);
        }
    }
}
