package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.NumberFormat;
import java.text.ParseException;

public class UpdateCheck extends JFrame {

    UpdateCheck() {

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(3, 45, 48));
        panel.setBounds(5, 5, 940, 490);
        add(panel);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
        Image image = icon.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon icon1 = new ImageIcon(image);
        JLabel label = new JLabel(icon1);
        label.setBounds(500, 60, 300, 300);
        panel.add(label);

        JLabel label1 = new JLabel("Check-In Details");
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

        JLabel label4 = new JLabel("Name:");
        label4.setBounds(25, 174, 97, 20);
        label4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        JTextField textField2 = new JTextField();
        textField2.setBounds(248, 174, 140, 20);
        panel.add(textField2);

        JLabel label5 = new JLabel("Check-In Date:");
        label5.setBounds(25, 215, 117, 20);
        label5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label5.setForeground(Color.WHITE);
        panel.add(label5);

        JTextField textField3 = new JTextField();
        textField3.setBounds(248, 215, 140, 20);
        panel.add(textField3);

        JLabel label6 = new JLabel("Amount Paid($):");
        label6.setBounds(25, 260, 117, 20);
        label6.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label6.setForeground(Color.WHITE);
        panel.add(label6);

        JTextField textField4 = new JTextField();
        textField4.setBounds(248, 260, 140, 20);
        panel.add(textField4);

        JLabel label7 = new JLabel("Pending Amount($):");
        label7.setBounds(25, 302, 130, 20);
        label7.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label7.setForeground(Color.WHITE);
        panel.add(label7);

        JTextField textField5 = new JTextField();
        textField5.setBounds(248, 302, 140, 20);
        panel.add(textField5);

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
                    String q = c.getSelectedItem();
                    String room = textField1.getText();
                    String name = textField2.getText();
                    String check = textField3.getText();
                    String amount = textField4.getText();

                    connect.statement.executeUpdate("update customer set room='" + room + "',name='" + name + "',check_in='" + check + "', deposit='" + amount + "' where number='" + q + "'");
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
                        textField2.setText(set.getString("name"));
                        textField3.setText(set.getString("check_in"));
                        textField4.setText(set.getString("deposit"));
                    } else {
                        JOptionPane.showMessageDialog(null, "No data found for the selected ID.");
                        return;
                    }

                    ResultSet resultSet = con.statement.executeQuery("select * from rooms where room_number='" + textField1.getText() + "'");

                    if (resultSet.next()) {
                        String price = resultSet.getString("price");

                        try {
                            NumberFormat format = NumberFormat.getInstance();
                            Number priceNumber = format.parse(price);
                            Number depositNumber = format.parse(textField4.getText());

                            int amtPaid = priceNumber.intValue() - depositNumber.intValue();
                            textField5.setText(String.valueOf(amtPaid));
                        } catch (ParseException D) {
                            D.printStackTrace();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "No room data found for the selected Room Number.");
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
        new UpdateCheck();
    }
}
