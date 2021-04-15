package by.it_academy.jd2.core.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AbstractConnection {
    private static String url = "jdbc:postgresql://localhost:5432/chat";
    private static String username = "postgres";
    private static String password = "admin";
    private static Connection connection = null;


    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            if (connection == null) {
                connection = DriverManager.getConnection(url, username, password);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException(e);
        }
        return connection;
    }
}
