package com.mycompany.heloo.Element;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/EStu";
    private static final String USER = "root";
    private static final String PASSWORD = "16092004";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

