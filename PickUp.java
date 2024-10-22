package Hotel_Management_System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class PickUp extends JFrame{

    PickUp(){
    JPanel panel = new JPanel();
    panel.setBackground(new Color(3, 45, 48));
    panel.setBounds(5,5,790,590);
    panel.setLayout(null);
    add(panel);

    JLabel Pus=new JLabel("Pick Up Service");
    Pus.setBounds(90,11,160,30);
    Pus.setFont(new Font("Tahoma", Font.BOLD, 20));
    Pus.setForeground(Color.white);
    panel.add(Pus);

        JLabel toc=new JLabel("Type Of Car");
        toc.setBounds(32,87,90,30);
        toc.setFont(new Font("Tahoma", Font.PLAIN, 14));
        toc.setForeground(Color.white);
        panel.add(toc);

        Choice c=new Choice();
        c.setBounds(125,94,150,25);
        c.setBackground(new Color(3, 45, 48));
        c.setForeground(Color.white);
        panel.add(c);

        try {
            Connect con=new Connect();
            ResultSet set=con.statement.executeQuery("select * from drivers");
            while(set.next()){
                c.add(set.getString("car_name"));
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        JTable table=new JTable();
        table.setBounds(10,233,800,250);
        table.setBackground(new Color(3,45,48));
        table.setForeground(Color.white);
        panel.add(table);

        try {
            Connect connect=new Connect();
            String q="Select * from drivers";
            ResultSet set=connect.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(set));

        }catch (Exception e) {
            e.printStackTrace();
        }

        JLabel name=new JLabel("Name");
        name.setBounds(24,208,46,19);
        name.setForeground(Color.white);
        panel.add(name);


        JLabel age=new JLabel("Age");
        age.setBounds(165,208,46,19);
        age.setForeground(Color.white);
        panel.add(age);



        JLabel gender=new JLabel("Gender");
        gender.setBounds(264,208,46,19);
        gender.setForeground(Color.white);
        panel.add(gender);


        JLabel company=new JLabel("Company");
        company.setBounds(366,208,70,19);
        company.setForeground(Color.white);
        panel.add(company);

        JLabel carName=new JLabel("Car Name");
        carName.setBounds(486,208,70,19);
        carName.setForeground(Color.white);
        panel.add(carName);

        JLabel availability=new JLabel("Availability");
        availability.setBounds(600,208,70,19);
        availability.setForeground(Color.white);
        panel.add(availability);

        JLabel loc=new JLabel("Location");
        loc.setBounds(710,208,70,19);
        loc.setForeground(Color.white);
        panel.add(loc);

        JButton display=new JButton("Display");
        display.setBounds(200,500,120,30);
        display.setForeground(Color.white);
        display.setBackground(Color.BLACK);
        panel.add(display);
        display.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent E) {

                if (E.getSource() == display){
                    String q="Select * from drivers where car_name='"+c.getSelectedItem()+"'";
                    try {
                        Connect con=new Connect();
                        ResultSet set=con.statement.executeQuery(q);
                        table.setModel(DbUtils.resultSetToTableModel(set));

                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }

            }


        });


        JButton back=new JButton("Back");
        back.setBounds(420,500,120,30);
        back.setForeground(Color.white);
        back.setBackground(Color.BLACK);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent E) {
                setVisible(false);
            }
        });


        setUndecorated(true);
        setLayout(null);
        setSize(800,600);
        setLocation(300,80);
        setVisible(true);


    }

    public static void main(String[] args) {
    new PickUp();
    }

}
