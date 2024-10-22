package Hotel_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployee extends JFrame implements ActionListener {

    JTextField nameText,AgeText,salaryText,phoneText,idCardText,emailText;
    JRadioButton radioButtonM,radioButtonF;
    JComboBox comboBox;
    JButton add,back;

    AddEmployee() {

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,890,490);
        panel.setBackground(new Color(3,45,48));
        add(panel);

        JLabel name = new JLabel("Name");
        name.setBounds(120,30,150,27);
        name.setFont(new Font("Serif", Font.BOLD, 20));
        name.setForeground(Color.WHITE);
        panel.add(name);

        nameText = new JTextField();
        nameText.setBounds(200,30,170,24);
        nameText.setFont(new Font("Serif", Font.PLAIN, 17));
        nameText.setBackground(new Color(16,108,115));
        nameText.setForeground(Color.WHITE);
        panel.add(nameText);


        JLabel Age = new JLabel("Age");
        Age.setBounds(120,80,150,27);
        Age.setFont(new Font("Serif", Font.BOLD, 20));
        Age.setForeground(Color.WHITE);
        panel.add(Age);

        AgeText = new JTextField();
        AgeText.setBounds(200,80,170,24);
        AgeText.setBackground(new Color(16,108,115));
        AgeText.setFont(new Font("Serif", Font.PLAIN, 17));
        AgeText.setForeground(Color.WHITE);
        panel.add(AgeText);


        JLabel gender = new JLabel("Gender");
        gender.setBounds(120,130,150,27);
        gender.setFont(new Font("Serif", Font.BOLD, 20));
        gender.setForeground(Color.WHITE);
        panel.add(gender);

        radioButtonM = new JRadioButton("Male");
        radioButtonM.setBounds(220,130,70,27);
        radioButtonM.setFont(new Font("Tahoma", Font.BOLD, 14));
        radioButtonM.setForeground(Color.WHITE);
        radioButtonM.setBackground(new Color(3,45,48));
        panel.add(radioButtonM);

        radioButtonF = new JRadioButton("Female");
        radioButtonF.setBounds(300,130,90,27);
        radioButtonF.setFont(new Font("Tahoma", Font.BOLD, 14));
        radioButtonF.setForeground(Color.WHITE);
        radioButtonF.setBackground(new Color(3,45,48));
        panel.add(radioButtonF);

        JLabel job = new JLabel("Job");
        job.setBounds(120,170,150,27);
        job.setFont(new Font("Serif", Font.BOLD, 20));
        job.setForeground(Color.WHITE);
        panel.add(job);

        comboBox= new JComboBox(new String[]{"Front Desk","House Keeping","Kitchen Staff","Room Service","Manager","Accountant","Chef"});
        comboBox.setBackground(new Color(16,108,115));
        comboBox.setBounds(200,170,170,30);
        comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
        comboBox.setForeground(Color.WHITE);
        panel.add(comboBox);


        JLabel salary = new JLabel("Salary");
        salary.setBounds(120,220,150,27);
        salary.setFont(new Font("Serif", Font.BOLD, 20));
        salary.setForeground(Color.WHITE);
        panel.add(salary);

        salaryText = new JTextField();
        salaryText.setBounds(200,220,170,24);
        salaryText.setBackground(new Color(16,108,115));
        salaryText.setFont(new Font("Serif", Font.PLAIN, 17));
        salaryText.setForeground(Color.WHITE);
        panel.add(salaryText);


        JLabel phone = new JLabel("Phone");
        phone.setBounds(120,260,150,27);
        phone.setFont(new Font("Serif", Font.BOLD, 20));
        phone.setForeground(Color.WHITE);
        panel.add(phone);

        phoneText = new JTextField();
        phoneText.setBounds(200,260,170,24);
        phoneText.setBackground(new Color(16,108,115));
        phoneText.setFont(new Font("Serif", Font.PLAIN, 17));
        phoneText.setForeground(Color.WHITE);
        panel.add(phoneText);


        JLabel IdCard = new JLabel("Id Card");
        IdCard.setBounds(120,300,150,27);
        IdCard.setFont(new Font("Serif", Font.BOLD, 20));
        IdCard.setForeground(Color.WHITE);
        panel.add(IdCard);

        idCardText = new JTextField();
        idCardText.setBounds(200,300,170,24);
        idCardText.setBackground(new Color(16,108,115));
        idCardText.setFont(new Font("Serif", Font.PLAIN, 17));
        idCardText.setForeground(Color.WHITE);
        panel.add(idCardText);


        JLabel email = new JLabel("Email");
        email.setBounds(120,340,150,27);
        email.setFont(new Font("Serif", Font.BOLD, 20));
        email.setForeground(Color.WHITE);
        panel.add(email);

        emailText = new JTextField();
        emailText.setBounds(200,340,170,24);
        emailText.setBackground(new Color(16,108,115));
        emailText.setFont(new Font("Serif", Font.PLAIN, 17));
        emailText.setForeground(Color.WHITE);
        panel.add(emailText);

        JLabel AED = new JLabel("Add Employee Details");
        AED.setBounds(450,24,445,35);
        AED.setFont(new Font("Serif", Font.BOLD, 35));
        AED.setForeground(Color.WHITE);
        panel.add(AED);

        add= new JButton("Add Employee");
        add.setBounds(80,420,130,30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        panel.add(add);

        back= new JButton("Back");
        back.setBounds(230,420,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        panel.add(back);

        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/addemp.png"));
        Image image=imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(image);
        JLabel label=new JLabel(imageIcon1);
        label.setBounds(500,100,300,300);
        panel.add(label);

        setUndecorated(true);
        setLayout(null);
        setLocation(60,160);
        setSize(900, 500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

      if(e.getSource()==add){

          String name = nameText.getText();
          String age = AgeText.getText();
          String gender = null;
          String phone = phoneText.getText();
          String id = idCardText.getText();
          String email = emailText.getText();
          String salary = salaryText.getText();
          String IdCard = idCardText.getText();
          String job=(String) comboBox.getSelectedItem();


          if(radioButtonM.isSelected()){
            gender="Male";
        }
          else if(radioButtonF.isSelected()){
            gender="Female";
        }

          try {

              Connect con = new Connect();

        String q= "insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+IdCard+"','"+email+"')";

if (name.isEmpty()||age.isEmpty()||gender.isEmpty()||job.isEmpty()||salary.isEmpty()||phone.isEmpty()||email.isEmpty()||IdCard.isEmpty()) {
    JOptionPane.showMessageDialog(null, "Please Complete all the fields");

}
    else {
    con.statement.executeUpdate(q);
    JOptionPane.showMessageDialog(null,"Employee Added Successfully");
    setVisible(true);

    }
        }
          catch (Exception exception){
              exception.printStackTrace();
          }

        }else {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
