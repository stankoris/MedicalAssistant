package com.MedicalAssistant.app.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MySQLConnector {
    private static Connection connection;

    public static Connection get() throws SQLException {
        if(connection == null) {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/MedicalAssistant", "jadmin", "1234");
        }
        return connection;
    }
}
