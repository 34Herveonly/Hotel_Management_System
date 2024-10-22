package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NewCustomer extends JFrame implements ActionListener {

    JComboBox<String> comboBox;
    JTextField textFieldNbr, textFieldName, textFieldCountry, textDeposit;
    JRadioButton r1, r2;
    Choice c1;
    JLabel date;
    JButton add, back;

    NewCustomer() {

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5, 5, 840, 540);
        panel.setBackground(new Color(3, 45, 48));
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/customer.png"));
        Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(550, 150, 200, 200);
        panel.add(label);

        JLabel labelName = new JLabel("New Customer Form");
        labelName.setBounds(118, 5, 260, 53);
        labelName.setFont(new Font("Tahoma", Font.BOLD, 20));
        labelName.setForeground(Color.WHITE);
        panel.add(labelName);

        JLabel labelId = new JLabel("Id:");
        labelId.setBounds(35, 76, 200, 14);
        labelId.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelId.setForeground(Color.WHITE);
        panel.add(labelId);

        comboBox = new JComboBox<>(new String[]{"Id Card Number", "Passport Id", "Voter id", "Driving License"});
        comboBox.setBounds(271, 73, 150, 20);
        comboBox.setForeground(Color.WHITE);
        comboBox.setBackground(new Color(3, 45, 48));
        comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(comboBox);

        JLabel labelNumber = new JLabel("Name:");
        labelNumber.setBounds(35, 111, 200, 14);
        labelNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelNumber.setForeground(Color.WHITE);
        panel.add(labelNumber);
        textFieldNbr = new JTextField();
        textFieldNbr.setBounds(271, 111, 150, 20);
        panel.add(textFieldNbr);

        JLabel labelNameText = new JLabel("Number:");
        labelNameText.setBounds(35, 149, 200, 14);
        labelNameText.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelNameText.setForeground(Color.WHITE);
        panel.add(labelNameText);
        textFieldName = new JTextField();
        textFieldName.setBounds(271, 149, 150, 20);
        panel.add(textFieldName);

        JLabel labelGender = new JLabel("Gender");
        labelGender.setBounds(35, 181, 200, 14);
        labelGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelGender.setForeground(Color.WHITE);
        panel.add(labelGender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        r1.setForeground(Color.WHITE);
        r1.setBackground(new Color(3, 45, 48));
        r1.setBounds(271, 181, 80, 12);
        panel.add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        r2.setForeground(Color.WHITE);
        r2.setBackground(new Color(3, 45, 48));
        r2.setBounds(350, 181, 80, 12);
        panel.add(r2);

        // Grouping the radio buttons
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(r1);
        genderGroup.add(r2);

        JLabel labelCountry = new JLabel("Country:");
        labelCountry.setBounds(35, 211, 200, 14);
        labelCountry.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelCountry.setForeground(Color.WHITE);
        panel.add(labelCountry);
        textFieldCountry = new JTextField();
        textFieldCountry.setBounds(271, 211, 150, 20);
        panel.add(textFieldCountry);

        JLabel labelRoom = new JLabel("Room Number:");
        labelRoom.setBounds(35, 249, 200, 14);
        labelRoom.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelRoom.setForeground(Color.WHITE);
        panel.add(labelRoom);

        c1 = new Choice();

        try {
            Connect c = new Connect();
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM rooms");
            while (resultSet.next()) {
                c1.add(resultSet.getString("Room_Number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        c1.setBounds(271, 249, 150, 20);
        c1.setFont(new Font("Tahoma", Font.BOLD, 14));
        c1.setForeground(Color.WHITE);
        c1.setBackground(new Color(3, 45, 48));
        panel.add(c1);

        JLabel labelCis = new JLabel("Checked-In:");
        labelCis.setBounds(35, 285, 200, 14);
        labelCis.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelCis.setForeground(Color.WHITE);
        panel.add(labelCis);

        Date date1 = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        date = new JLabel(sdf.format(date1));
        date.setBounds(271, 285, 200, 14);
        date.setFont(new Font("Tahoma", Font.PLAIN, 14));
        date.setForeground(Color.WHITE);
        panel.add(date);

        JLabel labelDeposit = new JLabel("Deposited :");
        labelDeposit.setBounds(35, 320, 200, 14);
        labelDeposit.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelDeposit.setForeground(Color.WHITE);
        panel.add(labelDeposit);
        textDeposit = new JTextField();
        textDeposit.setBounds(271, 320, 150, 20);
        panel.add(textDeposit);

        add = new JButton("Add");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(100, 430, 120, 25);
        panel.add(add);
        add.addActionListener(this);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(270, 430, 120, 25);
        panel.add(back);
        back.addActionListener(this);

        setUndecorated(true);
        setLayout(null);
        setLocation(400, 80);
        setSize(850, 550);
        setVisible(true);
    }

    public static void main(String[] args) {
        new NewCustomer();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == add) {

            String radioBtn = null;
            if (r1.isSelected()) {
                radioBtn = "Male";
            } else if (r2.isSelected()) {
                radioBtn = "Female";
            }

            String s1 = (String) comboBox.getSelectedItem();
            String s2 = textFieldName.getText();
            String s3 = textFieldNbr.getText();
            String s4 = radioBtn;
            String s5 = textFieldCountry.getText();
            String s6 = c1.getSelectedItem();
            String s7 = date.getText();
            String s8 = textDeposit.getText();

            // Check if any fields are empty
            if (s2.isEmpty() || s3.isEmpty() || s4 == null || s5.isEmpty() || s8.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please complete all fields.");
                return;
            }

            String sql = "INSERT INTO customer (document, number, name, gender, country, room, check_in, deposit) VALUES ('" + s1 + "','" + s2 + "','" + s3 + "','" + s4 + "','" + s5 + "','" + s6 + "','" + s7 + "','" + s8 + "')";
            String q = "UPDATE rooms SET Avaiability='Occupied' WHERE Room_Number='" + s6 + "'";

            try {
                Connect connect = new Connect();
                connect.statement.executeUpdate(sql);
                connect.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Customer Added Successfully");
                setVisible(false);

            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: Unable to add customer.");
            }
        } else if (e.getSource() == back) {
            setVisible(false);
        }
    }
}
