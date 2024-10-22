package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {
    JButton add,rec;

    Dashboard(){
        super("Hotel Management System");

        rec=new JButton("Reception");
        rec.setBounds(425,510,140,30);
        rec.setFont(new Font("Tahoma",Font.BOLD,15));
        rec.setBackground(new Color(255,98,0));
        rec.setForeground(Color.white);
        rec.addActionListener(this);
        add(rec);


        add=new JButton("Admin");
        add.setBounds(880,510,140,30);
        add.setFont(new Font("Tahoma",Font.BOLD,15));
        add.setBackground(new Color(255,98,0));
        add.setForeground(Color.white);
        add.addActionListener(this);
        add(add);


        ImageIcon icon1=new ImageIcon(ClassLoader.getSystemResource("icon/boss.png"));
        Image i2= icon1.getImage().getScaledInstance(200, 195, Image.SCALE_DEFAULT);
        ImageIcon icon2=new ImageIcon(i2);
        JLabel label=new JLabel(icon2);
        label.setBounds(850, 300, 200, 195);
        add(label);


        ImageIcon icon11=new ImageIcon(ClassLoader.getSystemResource("icon/Reception.png"));
        Image i22= icon11.getImage().getScaledInstance(200, 195, Image.SCALE_DEFAULT);
        ImageIcon icon22=new ImageIcon(i22);
        JLabel label2=new JLabel(icon22);
        label2.setBounds(400, 300, 200, 195);
        add(label2);

        ImageIcon icon=new ImageIcon(ClassLoader.getSystemResource("icon/Dashboard.gif"));
        Image i1= icon.getImage().getScaledInstance(1950, 1090, Image.SCALE_DEFAULT);
        ImageIcon icon3=new ImageIcon(i1);
        JLabel label1=new JLabel(icon3);
        label1.setBounds(0, 0, 1950, 1090);
        add(label1);


        setTitle("Dashboard");
        setSize(1950, 1090);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Dashboard();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==rec){

            new Reception();
    }

    else {

        new Login2();
        setVisible(false);

    }

    }
}
