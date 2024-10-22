package Hotel_Management_System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame implements ActionListener {

 Department(){

     JPanel panel = new JPanel();
     panel.setBackground(new Color(3,45,48));
     panel.setBounds(5,5,690,490);
     panel.setLayout(null);
     add(panel);

     JTable table=new JTable();
     table.setBounds(0,40,700,350);
     table.setBackground(new Color(4,45,48));
     table.setForeground(Color.WHITE);
     panel.add(table);

     try {

         Connect con=new Connect();
         String sql="select * from department";
         ResultSet resultSet=con.statement.executeQuery(sql);
         table.setModel(DbUtils.resultSetToTableModel(resultSet));

         JButton back=new JButton("Back");
         back.setBounds(200,410,120,30);
         back.setBackground(Color.BLACK);
         back.setForeground(Color.WHITE);
         panel.add(back);
         back.addActionListener(this);

         JLabel lbl=new JLabel("Department");
         lbl.setBounds(145,11,105,20);
         lbl.setFont(new Font("Tahoma", Font.BOLD, 14));
         lbl.setForeground(Color.WHITE);
         panel.add(lbl);


         JLabel label=new JLabel("Budget");
         label.setBounds(431,11,105,20);
         label.setFont(new Font("Tahoma", Font.BOLD, 14));
         label.setForeground(Color.WHITE);
         panel.add(label);

     }catch (Exception e){
         e.printStackTrace();
     }

     setUndecorated(true);
     setLayout(null);
     setLocation(350,150);
     setSize(700,500);
     setVisible(true);

 }

    public static void main(String[] args) {
     new Department();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }
}
