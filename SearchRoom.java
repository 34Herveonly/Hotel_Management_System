package Hotel_Management_System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom extends JFrame implements ActionListener {

    JTable table;
    JCheckBox checkBox;
    Choice choice;
    JButton add,back;

    SearchRoom(){
    JPanel panel = new JPanel();
    panel.setLayout(null);
    panel.setBackground(new Color(3,45,48));
    panel.setBounds(5, 5, 690, 490);
    add(panel);


       JLabel searchForRoom = new JLabel("Search For Room");
       searchForRoom.setBounds(250,11,186,31);
       searchForRoom.setForeground(Color.WHITE);
       searchForRoom.setFont(new Font("Tahoma", Font.BOLD, 20));
       panel.add(searchForRoom);


        JLabel roomBedType = new JLabel("Room Bed Type:");
        roomBedType.setBounds(33,63,120,31);
        roomBedType.setForeground(Color.WHITE);
        roomBedType.setFont(new Font("Tahoma", Font.BOLD, 13));
        panel.add(roomBedType);

        JLabel rn = new JLabel("Room Number");
        rn.setBounds(23,162,150,31);
        rn.setForeground(Color.WHITE);
        rn.setFont(new Font("Tahoma", Font.BOLD, 13));
        panel.add(rn);

        JLabel availability = new JLabel("Availability");
        availability.setBounds(165,162,150,31);
        availability.setForeground(Color.WHITE);
        availability.setFont(new Font("Tahoma", Font.BOLD, 13));
        panel.add(availability);

        JLabel price = new JLabel("Price");
        price.setBounds(458,162,150,31);
        price.setForeground(Color.WHITE);
        price.setFont(new Font("Tahoma", Font.BOLD, 13));
        panel.add(price);

        JLabel BT = new JLabel("Bed Type");
        BT.setBounds(580,162,150,31);
        BT.setForeground(Color.WHITE);
        BT.setFont(new Font("Tahoma", Font.BOLD, 13));
        panel.add(BT);

        JLabel SS = new JLabel("Cleaning Status");
        SS.setBounds(300,162,150,31);
        SS.setForeground(Color.WHITE);
        SS.setFont(new Font("Tahoma", Font.BOLD, 13));
        panel.add(SS);


        checkBox = new JCheckBox("Only Display Available ");
    checkBox.setBounds(400,69,205,23);
    checkBox.setForeground(Color.WHITE);
    checkBox.setBackground(new Color(3,45,48));
    panel.add(checkBox);

    choice=new Choice();
    choice.add("Single Bed");
    choice.add("Double Bed");
    choice.setBounds(153,70,120,20);
    panel.add(choice);

    table=new JTable();
    table.setBounds(0,187,700,150);
    table.setBackground(new Color(3,45,48));
    table.setForeground(Color.WHITE);
    panel.add(table);

    try {
        Connect connect=new Connect();
        String q="select * from rooms ";
        ResultSet resultSet= connect.statement.executeQuery(q);
        table.setModel(DbUtils.resultSetToTableModel(resultSet));

        add=new JButton("Search");
        add.setBounds(200,400,120,30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        panel.add(add);

        back=new JButton("Back");
        back.setBounds(380,400,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        panel.add(back);

    }catch (Exception e){
        e.printStackTrace();
    }

        setUndecorated(true);
        setLayout(null);
        setLocation(500,90);
        setSize(700,500);
        setVisible(true);
    }

    public static void main(String[] args) {
    new SearchRoom();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==add){

            String sql="select * from rooms where bed_type='"+choice.getSelectedItem()+"'";
            String q="select * from rooms where Avaiability='Available' AND bed_type='"+choice.getSelectedItem()+"'";

            try {

                Connect connect=new Connect();
                ResultSet resultSet=connect.statement.executeQuery(sql);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));

                if(checkBox.isSelected()){
                    ResultSet set=connect.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(set));
                }

            }
            catch (Exception exception){
                exception.printStackTrace();
            }
        }
        else {
            setVisible(false);
        }

    }
}
