package Hotel_Management_System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connect {
    Connection connection;
    Statement statement;

    public Connect() {
        try {
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/HotelMs"
                    ,"root","Moneygram34");

            statement=connection.createStatement();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
