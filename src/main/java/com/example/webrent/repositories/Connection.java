package com.example.webrent.repositories;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {

    public static java.sql.Connection connection;

    static {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://hostserver.mysql.database.azure.com:3306/rent?useSSL=true","user", "Pavlo121");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
