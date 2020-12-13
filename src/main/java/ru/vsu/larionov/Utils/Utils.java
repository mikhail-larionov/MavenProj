package ru.vsu.larionov.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utils {
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
    }
}
