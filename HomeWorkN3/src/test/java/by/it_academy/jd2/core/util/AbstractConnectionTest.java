package by.it_academy.jd2.core.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.sql.SQLException;


import static org.junit.jupiter.api.Assertions.*;

public class AbstractConnectionTest {
    java.sql.Connection connection = null;

    @Test
    public void getConnection() {

        try {
            connection =  AbstractConnection.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Assertions.assertTrue(connection!=null);
    }

}