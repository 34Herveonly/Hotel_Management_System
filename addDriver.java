package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addDriver extends JFrame implements ActionListener {

    JTextField nameTextField,ageText,carCText,carNText,locText;
    JComboBox genderText,comboBox;
    JButton add,back;

    addDriver(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,490);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        JLabel label=new JLabel("Add Drivers");
        label.setBounds(154,10,200,22);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Tahoma",Font.BOLD,25));
        panel.add(label);

        JLabel name=new JLabel("Name");
        name.setBounds(44,70,102,22);
        name.setFont(new Font("Tahoma",Font.BOLD,18));
        name.setForeground(Color.WHITE);
        panel.add(name);
        nameTextField = new JTextField();
        nameTextField.setBounds(144,70,154,20);
        nameTextField.setFont(new Font("Tahoma",Font.BOLD,14));
        nameTextField.setBackground(new Color(16,108,115));
        nameTextField.setForeground(Color.WHITE);
        panel.add(nameTextField);


        JLabel age=new JLabel("Age");
        age.setBounds(44,110,102,22);
        age.setFont(new Font("Tahoma",Font.BOLD,18));
        age.setForeground(Color.WHITE);
        panel.add(age);
        ageText = new JTextField();
        ageText.setBounds(144,110,154,20);
        ageText.setFont(new Font("Tahoma",Font.BOLD,14));
        ageText.setBackground(new Color(16,108,115));
        ageText.setForeground(Color.WHITE);
        panel.add(ageText);


        JLabel gender=new JLabel("Gender");
        gender.setBounds(44,150,102,22);
        gender.setFont(new Font("Tahoma",Font.BOLD,18));
        gender.setForeground(Color.WHITE);
        panel.add(gender);
        genderText = new JComboBox(new String[]{"Male","Female"});
        genderText.setBounds(144,150,154,20);
        genderText.setFont(new Font("Tahoma",Font.BOLD,14));
        genderText.setBackground(new Color(16,108,115));
        genderText.setForeground(Color.WHITE);
        panel.add(genderText);


        JLabel carC=new JLabel("Car Company");
        carC.setBounds(44,190,140,22);
        carC.setFont(new Font("Tahoma",Font.BOLD,14));
        carC.setForeground(Color.WHITE);
        panel.add(carC);
        carCText = new JTextField();
        carCText.setBounds(144,190,154,20);
        carCText.setFont(new Font("Tahoma",Font.BOLD,14));
        carCText.setBackground(new Color(16,108,115));
        carCText.setForeground(Color.WHITE);
        panel.add(carCText);


        JLabel carN=new JLabel("Car Name");
        carN.setBounds(44,230,102,22);
        carN.setFont(new Font("Tahoma",Font.BOLD,18));
        carN.setForeground(Color.WHITE);
        panel.add(carN);
        carNText = new JTextField();
        carNText.setBounds(144,230,154,20);
        carNText.setFont(new Font("Tahoma",Font.BOLD,14));
        carNText.setBackground(new Color(16,108,115));
        carNText.setForeground(Color.WHITE);
        panel.add(carNText);



        JLabel available=new JLabel("Available");
        available.setBounds(44,270,102,22);
        available.setFont(new Font("Tahoma",Font.BOLD,18));
        available.setForeground(Color.WHITE);
        panel.add(available);
        comboBox= new JComboBox(new String[]{"Yes","No"});
        comboBox.setBounds(144,270,154,20);
        comboBox.setFont(new Font("Tahoma",Font.BOLD,14));
        comboBox.setBackground(new Color(16,108,115));
        comboBox.setForeground(Color.WHITE);
        panel.add(comboBox);


        JLabel loc=new JLabel("Location");
        loc.setBounds(44,310,102,22);
        loc.setFont(new Font("Tahoma",Font.BOLD,18));
        loc.setForeground(Color.WHITE);
        panel.add(loc);
        locText = new JTextField();
        locText.setBounds(144,310,154,20);
        locText.setFont(new Font("Tahoma",Font.BOLD,14));
        locText.setBackground(new Color(16,108,115));
        locText.setForeground(Color.WHITE);
        panel.add(locText);

        add=new JButton("Add");
        add.setBounds(44,380,111,33);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        panel.add(add);

        back=new JButton("Back");
        back.setBounds(200,380,111,33);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        panel.add(back);

        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/license.png"));
        Image image=imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(image);
        JLabel imageLabel=new JLabel(imageIcon1);
        imageLabel.setBounds(500,60,300,300);
        panel.add(imageLabel);

        setUndecorated(true);
        setLocation(20,120);
        setLayout(null);
        setSize(900,500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==add){

            String name=nameTextField.getText();
            String age=ageText.getText();
            String gender=(String)genderText.getSelectedItem();
            String company=carCText.getText();
            String location=locText.getText();
            String carNm=carNText.getText();
            String available=(String)comboBox.getSelectedItem();

            try {
                Connect con=new Connect();

                String q="insert into drivers values('"+name+"','"+age+"','"+gender+"','"+company+"','"+carNm+"','"+available+"','"+location+"')";

               if (name.isEmpty()||age.isEmpty()||gender.isEmpty()||company.isEmpty()||location.isEmpty()||carNm.isEmpty()||available.isEmpty()){
                   JOptionPane.showMessageDialog(null, "Please Complete all the fields");

               }
               else {

                   con.statement.executeUpdate(q);
                   JOptionPane.showMessageDialog(null, "Driver Added");
                   setVisible(false);
               }
            }catch (Exception exception){
                exception.printStackTrace();
            }


        }else if(e.getSource()==back){
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new addDriver();
    }

}
