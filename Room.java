package Hotel_Management_System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Room extends JFrame implements ActionListener {

    JTable table;
    JButton back;

    Room() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5, 5, 890, 590);
        panel.setBackground(new Color(3, 45, 48));
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/roomm.png"));
        Image image = imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon icon = new ImageIcon(image);
        JLabel label = new JLabel(icon);
        label.setBounds(550, 250, 300, 300);  // Set bounds for the label to ensure it displays correctly
        panel.add(label);

        table = new JTable();
        table.setBounds(10, 40, 500, 400);
        table.setBackground(new Color(3, 45, 48));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try {
            Connect conn = new Connect();
            String RoomInfo = "select * from rooms";
            ResultSet resultSet = conn.statement.executeQuery(RoomInfo);
            table.setModel(DbUtils.resultSetToTableModel(resultSet)); // Now table is initialized

        } catch (Exception e) {
            e.printStackTrace();
        }
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200,500,120,30);
        back.addActionListener(this);
        panel.add(back);


        JLabel roomN = new JLabel("Room No.");
        roomN.setBounds(12,15,80,19);
        roomN.setForeground(Color.WHITE);
        roomN.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(roomN);

        JLabel availability = new JLabel("Availability");
        availability.setBounds(119,15,80,19);
        availability.setForeground(Color.WHITE);
        availability.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(availability);

        JLabel clean = new JLabel("Cleaning Status");
        clean.setBounds(216,15,150,19);
        clean.setForeground(Color.WHITE);
        clean.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(clean);

        JLabel price = new JLabel("Price");
        price.setBounds(330,15,150,19);
        price.setForeground(Color.WHITE);
        price.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(price);


        JLabel Bed = new JLabel("Bed Type");
        Bed.setBounds(417,15,150,19);
        Bed.setForeground(Color.WHITE);
        Bed.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(Bed);

        setUndecorated(true);
        setLayout(null);
        setLocation(350, 100);
        setSize(900, 600);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Room();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }
}
