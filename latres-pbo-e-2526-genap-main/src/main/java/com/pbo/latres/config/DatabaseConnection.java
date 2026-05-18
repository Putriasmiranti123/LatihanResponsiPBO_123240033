package com.pbo.latres.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL =
        "jdbc:mysql://localhost:3306/todo_db";

    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static Connection connection;

    private DatabaseConnection() {}

    public static Connection getConnection() throws SQLException {

        if (connection == null || connection.isClosed()) {

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

            } catch (ClassNotFoundException e) {

                throw new SQLException(
                    "MySQL JDBC Driver tidak ditemukan.",
                    e
                );
            }

            connection = DriverManager.getConnection(
                URL,
                USER,
                PASSWORD
            );
        }

        return connection;
    }
}