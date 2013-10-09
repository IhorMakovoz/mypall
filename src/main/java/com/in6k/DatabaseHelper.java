package com.in6k;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHelper {
    public static final String MYSQL_CONNECTION_STRING = "jdbc:mysql://localhost:3306/mypal";
    public static final String USER = "root";
    public static final String PASSWORD = "masterkey";

    private static Connection connection = null;

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        if (connection == null) {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(MYSQL_CONNECTION_STRING, USER, PASSWORD);
        }

        return connection;
    }
}
