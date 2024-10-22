package Hotel_Management_System;

import javax.swing.*;

public class Splash extends JFrame {

    Splash(){
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/splash.gif"));
        JLabel label = new JLabel(imageIcon);
        label.setBounds(0,0,858,680);
        add(label);


        setLayout(null);
        setLocation(300,20);
        setSize(858,680);
        setTitle("Hotel Management System");
        setVisible(true);

        try{
            Thread.sleep(5000);
            new Login();
            setVisible(false);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Splash();
    }
}
