package Hotel_Management_System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class CustomerInfo extends JFrame implements ActionListener {

    CustomerInfo(){

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,890,590);
        panel.setBackground(new Color(3,45,48));
        add(panel);

        JTable table = new JTable();
        table.setBounds(10,40,900,450);
        table.setBackground(new Color(3,45,48));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try {
            Connect con = new Connect();
            String query = "select * from customer";
            ResultSet resultSet=con.statement.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }
        catch (Exception e){
            e.printStackTrace();
        }

        JLabel idLabel = new JLabel("ID");
        idLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        idLabel.setBounds(27,11,46,14);
        idLabel.setForeground(Color.WHITE);
        panel.add(idLabel);

        JLabel name = new JLabel("Name");
        name.setFont(new Font("Tahoma", Font.BOLD, 14));
        name.setBounds(150,11,70,14);
        name.setForeground(Color.WHITE);
        panel.add(name);


        JLabel number = new JLabel("Number");
        number.setFont(new Font("Tahoma", Font.BOLD, 14));
        number.setBounds(270,11,70,14);
        number.setForeground(Color.WHITE);
        panel.add(number);


        JLabel gender = new JLabel("Gender");
        gender.setFont(new Font("Tahoma", Font.BOLD, 14));
        gender.setBounds(370,11,70,14);
        gender.setForeground(Color.WHITE);
        panel.add(gender);


        JLabel country = new JLabel("Country");
        country.setFont(new Font("Tahoma", Font.BOLD, 14));
        country.setBounds(480,11,70,14);
        country.setForeground(Color.WHITE);
        panel.add(country);


        JLabel room = new JLabel("Room No");
        room.setFont(new Font("Tahoma", Font.BOLD, 14));
        room.setBounds(580,11,70,14);
        room.setForeground(Color.WHITE);
        panel.add(room);


        JLabel date = new JLabel("Check In Date");
        date.setFont(new Font("Tahoma", Font.BOLD, 14));
        date.setBounds(690,11,100,14);
        date.setForeground(Color.WHITE);
        panel.add(date);


        JLabel deposit = new JLabel("Deposited");
        deposit.setFont(new Font("Tahoma", Font.BOLD, 14));
        deposit.setBounds(810,11,100,14);
        deposit.setForeground(Color.WHITE);
        panel.add(deposit);

        JButton back = new JButton("Back");
        back.setBounds(450,510,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        panel.add(back);

        setUndecorated(true);
        setLayout(null);
        setSize(900, 600);
        setLocation(350,80);
        setVisible(true);

    }

    public static void main(String[] args) {
        new CustomerInfo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }
}
