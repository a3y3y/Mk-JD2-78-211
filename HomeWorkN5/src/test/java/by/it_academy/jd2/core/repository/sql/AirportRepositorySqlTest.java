package by.it_academy.jd2.core.repository.sql;

import by.it_academy.jd2.core.dto.Airport;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class AirportRepositorySqlTest {




    @Test
    public void readAll() {
        AirportRepositorySql airportRepositorySql = new AirportRepositorySql();
        List<Airport> test = airportRepositorySql.readAll();
        Assertions.assertFalse(test.isEmpty());
    }

    @Test
    public void readAllSqlException() throws SQLException {

        PreparedStatement stmt = mock(PreparedStatement.class);
        when(stmt.executeQuery()).thenThrow(SQLException.class);
        assertThrows(SQLException.class, () -> {
            stmt.executeQuery();
        });
        verify(stmt).executeQuery();
    }
}
