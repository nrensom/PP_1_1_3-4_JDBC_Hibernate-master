package jm.task.core.jdbc.util;

import jm.task.core.jdbc.Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util implements AutoCloseable {
    static final private String URL = "jdbc:mysql://localhost:3306/test";
    static final private String LOGIN = "root";
    static final private String PASSWORD = "root";
    static Connection connection;

    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    @Override
    public void close() throws Exception {

    }
    // реализуйте настройку соеденения с БД
}
