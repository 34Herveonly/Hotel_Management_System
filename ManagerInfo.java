package Hotel_Management_System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ManagerInfo extends JFrame implements ActionListener {

    ManagerInfo(){


        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,990,590);
        panel.setBackground(new Color(3,45,48));
        add(panel);

        JTable table = new JTable();
        table.setBounds(10,34,980,450);
        table.setBackground(new Color(3,45,48));
        table.setForeground(Color.white);
        panel.add(table);

        JButton back = new JButton("Back");
        back.setBounds(350,500,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        panel.add(back);
        back.addActionListener(this);

        try {
            Connect con=new Connect();
            String sql="select * from employee where job='Manager'";
            ResultSet resultSet=con.statement.executeQuery(sql);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }
        catch (Exception e){
            e.printStackTrace();
        }

        JLabel name=new JLabel("Employee Name");
        name.setFont(new Font("Tahoma",Font.BOLD,14));
        name.setForeground(Color.white);
        name.setBounds(10,11,200,19);
        panel.add(name);

        JLabel age=new JLabel("Age");
        age.setFont(new Font("Tahoma",Font.BOLD,14));
        age.setForeground(Color.white);
        age.setBounds(159,11,70,19);
        panel.add(age);

        JLabel gender=new JLabel("Gender");
        gender.setFont(new Font("Tahoma",Font.BOLD,14));
        gender.setForeground(Color.white);
        gender.setBounds(263,11,70,19);
        panel.add(gender);

        JLabel job=new JLabel("Job Position");
        job.setFont(new Font("Tahoma",Font.BOLD,14));
        job.setForeground(Color.white);
        job.setBounds(380,11,100,19);
        panel.add(job);


        JLabel salary=new JLabel("Salary");
        salary.setFont(new Font("Tahoma",Font.BOLD,14));
        salary.setForeground(Color.white);
        salary.setBounds(510,11,70,19);
        panel.add(salary);

        JLabel phone=new JLabel("Phone");
        phone.setFont(new Font("Tahoma",Font.BOLD,14));
        phone.setForeground(Color.white);
        phone.setBounds(630,11,70,19);
        panel.add(phone);

        JLabel idNum=new JLabel("Id_Card Nbr");
        idNum.setFont(new Font("Tahoma",Font.BOLD,14));
        idNum.setForeground(Color.white);
        idNum.setBounds(750,11,150,19);
        panel.add(idNum);


        JLabel gmail=new JLabel("Email");
        gmail.setFont(new Font("Tahoma",Font.BOLD,14));
        gmail.setForeground(Color.white);
        gmail.setBounds(900,11,150,19);
        panel.add(gmail);


        setUndecorated(true);
        setLayout(null);
        setLocation(290,70);
        setSize(1000,600);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }

    public static void main(String[] args) {
        new ManagerInfo();
    }
}

