package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.NumberFormat;
import java.text.ParseException;

public class UpdateRoom extends JFrame {

    UpdateRoom() {


        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(3, 45, 48));
        panel.setBounds(5, 5, 940, 490);
        add(panel);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icon/update.png"));
        Image image = icon.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon icon1 = new ImageIcon(image);
        JLabel label = new JLabel(icon1);
        label.setBounds(500, 60, 300, 300);
        panel.add(label);

        JLabel label1 = new JLabel("Update Room Status ");
        label1.setBounds(124, 11, 222, 25);
        label1.setFont(new Font("Tahoma", Font.BOLD, 20));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        JLabel label2 = new JLabel("Id:");
        label2.setBounds(25, 88, 46, 20);
        label2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label2.setForeground(Color.WHITE);
        label2.setBackground(new Color(3, 45, 48));
        panel.add(label2);

        Choice c = new Choice();
        c.setBounds(248, 85, 140, 20);
        panel.add(c);

        try {
            Connect con = new Connect();
            ResultSet set = con.statement.executeQuery("select * from customer");
            while (set.next()) {
                c.add(set.getString("number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label3 = new JLabel("Room No:");
        label3.setBounds(25, 129, 107, 20);
        label3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        JTextField textField1 = new JTextField();
        textField1.setBounds(248, 129, 140, 20);
        panel.add(textField1);

        JLabel label4 = new JLabel("Availability:");
        label4.setBounds(25, 174, 97, 20);
        label4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        JTextField textField2 = new JTextField();
        textField2.setBounds(248, 174, 140, 20);
        panel.add(textField2);

        JLabel label5 = new JLabel("Clean Status");
        label5.setBounds(25, 215, 117, 20);
        label5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label5.setForeground(Color.WHITE);
        panel.add(label5);

        JTextField textField3 = new JTextField();
        textField3.setBounds(248, 215, 140, 20);
        panel.add(textField3);


        JButton update = new JButton("Update");
        update.setBounds(168, 378, 89, 25);
        update.setForeground(Color.WHITE);
        update.setBackground(Color.BLACK);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connect connect = new Connect();
                    String status = textField3.getText();
            connect.statement.executeUpdate("update rooms set cleaning_status = '" + status + "' where Room_Number = '" + textField1.getText() + "'");

                    JOptionPane.showMessageDialog(null, "Updated Successfully");
                    setVisible(false);

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(290, 378, 89, 25);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        panel.add(back);

        JButton check = new JButton("Check");
        check.setBounds(410, 378, 89, 25);
        check.setForeground(Color.WHITE);
        check.setBackground(Color.BLACK);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = c.getSelectedItem();
                String q = "select * from customer where number='" + id + "'";

                try {
                    Connect con = new Connect();
                    ResultSet set = con.statement.executeQuery(q);

                    if (set.next()) {
                        textField1.setText(set.getString("room"));

                    } else {
                        JOptionPane.showMessageDialog(null, "No data found for the selected ID.");
                        return;
                    }

                    ResultSet resultSet = con.statement.executeQuery("select * from rooms where room_number='" + textField1.getText() + "'");

                    while (resultSet.next()) {
                        textField2.setText(resultSet.getString("Avaiability"));
                        textField3.setText(resultSet.getString("cleaning_status"));
                    }

                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });

        setUndecorated(true);
        setLayout(null);
        setSize(950, 500);
        setLocation(300, 120);
        setVisible(true);
    }


    public static void main(String[] args) {
        new UpdateRoom();
    }
}
