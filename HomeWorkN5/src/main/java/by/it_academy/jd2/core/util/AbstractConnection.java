package by.it_academy.jd2.core.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Creates connection to database
 * @author Maksim Perekladov
 * @version 0.0
 */

public abstract class AbstractConnection {
    /** URL address for database. */
    private static String url = "jdbc:postgresql://localhost:5432/demo";

    /** Username for connection to database. */
    private static String username = "postgres";

    /** Password for connection to database. */
    private static String password = "admin";

    /** Creates static Connecion object. */
    private static Connection connection = null;


    /** Creates connection to database.
     * @return Connection
     * @throws SQLException - exception thrown by ClassNotFoundException or SQLException
     * */
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