package Hotel_Management_System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class CheckOut extends JFrame {
    CheckOut(){

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,790,390);
        panel.setBackground(new Color(3,45,48));
        add(panel);



        JLabel label = new JLabel("Check-Out");
        label.setBounds(100,20,150,30);
        label.setFont(new Font("Tahoma",Font.PLAIN,20));
        label.setForeground(Color.WHITE);
        panel.add(label);


        JLabel userId = new JLabel("Customer Id");
        userId.setBounds(30,80,150,30);
        userId.setFont(new Font("Tahoma",Font.BOLD,14));
        userId.setForeground(Color.WHITE);
        panel.add(userId);

        Choice customer=new Choice();
        customer.setBounds(190,80,150,25);
        panel.add(customer);

        JLabel roomNo = new JLabel("Room Number");
        roomNo.setBounds(30,130,150,30);
        roomNo.setFont(new Font("Tahoma",Font.BOLD,14));
        roomNo.setForeground(Color.WHITE);
        panel.add(roomNo);

        JLabel labelRoomNo = new JLabel();
        labelRoomNo.setBounds(190,130,150,30);
        labelRoomNo.setFont(new Font("Tahoma",Font.BOLD,14));
        labelRoomNo.setForeground(Color.WHITE);
        panel.add(labelRoomNo);

        JLabel checkInTime = new JLabel("Check-In Time");
        checkInTime.setBounds(30,180,150,30);
        checkInTime.setFont(new Font("Tahoma",Font.BOLD,14));
        checkInTime.setForeground(Color.WHITE);
        panel.add(checkInTime);


        JLabel labelCheckInTime = new JLabel();
        labelCheckInTime.setBounds(190,180,150,30);
        labelCheckInTime.setFont(new Font("Tahoma",Font.BOLD,14));
        labelCheckInTime.setForeground(Color.WHITE);
        panel.add(labelCheckInTime);

        JLabel checkOut = new JLabel("Check-Out Time");
        checkOut.setBounds(30,230,150,30);
        checkOut.setFont(new Font("Tahoma",Font.BOLD,14));
        checkOut.setForeground(Color.WHITE);
        panel.add(checkOut);

        Date date=new Date();

        JLabel labelCheckOut = new JLabel(""+date);
        labelCheckOut.setBounds(190,230,250,30);
        labelCheckOut.setFont(new Font("Tahoma",Font.BOLD,14));
        labelCheckOut.setForeground(Color.WHITE);
        panel.add(labelCheckOut);

        try{
            Connect connect=new Connect();
            ResultSet resultSet=connect.statement.executeQuery("select * from customer");
            while (resultSet.next()){
                customer.add(resultSet.getString("number"));
            }
        }catch (Exception e){
            e.printStackTrace();
         }

        JButton CheckOut=new JButton("Check-Out");
        CheckOut.setBounds(30,300,120,30);
        CheckOut.setForeground(Color.WHITE);
        CheckOut.setBackground(Color.BLACK);
        panel.add(CheckOut);
        CheckOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    Connect c=new Connect();
                    c.statement.executeUpdate("delete from customer where number='"+customer.getSelectedItem()+"'");
                    c.statement.executeUpdate("update rooms set Avaiability='Available' where Room_number='"+labelRoomNo.getText()+"'");
                    JOptionPane.showMessageDialog(null,"Successfully Checked-Out");
                    setVisible(false);
                }catch (Exception e1) {
                    e1.printStackTrace();
                }

            }
        });

        JButton check=new JButton("Check");
        check.setBounds(300,300,120,30);
        check.setForeground(Color.WHITE);
        check.setBackground(Color.BLACK);
        panel.add(check);
        check.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
           Connect connect=new Connect();
           try{
               ResultSet resultSet=connect.statement.executeQuery("select * from customer where number='"+customer.getSelectedItem()+"'");

               while (resultSet.next()){
                   labelRoomNo.setText(resultSet.getString("room"));
                   labelCheckInTime.setText(resultSet.getString("check_in"));

               }

           }catch (Exception e1){
               e1.printStackTrace();
           }
            }
        });

        JButton back=new JButton("Back");
        back.setBounds(170,300,120,30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        setUndecorated(true);
        setSize(800,400);
        setLocation(400,210);
        setVisible(true);
    }






    public static void main(String[] args) {
    new CheckOut();
    }
}