package by.it_academy.jd2.core.repository.sql;

import by.it_academy.jd2.core.dto.Airport;
import by.it_academy.jd2.core.dto.Flight;
import org.junit.jupiter.api.*;
import org.mockito.Mock;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class FlightRepositorySqlTest {


    FlightRepositorySql flightRepositorySql = new FlightRepositorySql();
    private String date1 = "2016-08-15";
    private String date2 = "2017-09-14";
    private String departureAirport = "Domodedovo International Airport";
    private String arrivalAirport = "Yelizovo Airport";
    private List<Flight> flights = new ArrayList<>();
    private Flight flight = new Flight("test", "test", "test", "test", "test",
            "test", "test");

    {
        flights.add(flight);
    }

    FlightRepositorySql frs = mock(FlightRepositorySql.class);

    @Test
    public void readPartOfFlightsByDate() {
        when(frs.readPartOfFlightsByDate(date1, date2, departureAirport
                , arrivalAirport, 0, 25)).thenReturn(flights);
        Assertions.assertEquals(frs.readPartOfFlightsByDate(date1, date2, departureAirport
                , arrivalAirport, 0, 25), flights);
        verify(frs).readPartOfFlightsByDate(date1, date2, departureAirport
                , arrivalAirport, 0, 25);
        List<Flight> testList = flightRepositorySql.readPartOfFlightsByDate(date1, date2, departureAirport
                , arrivalAirport, 0, 25);
        Assertions.assertFalse(testList.isEmpty());

    }

    @Test
    public void getNumberOfStrings() {
        int test = flightRepositorySql.getNumberOfStrings(date1, date2, departureAirport, arrivalAirport);
        Assertions.assertTrue(test > 0);

    }

    @Test
    public void testSqlException() throws SQLException {
        ResultSet rs = mock(ResultSet.class);
        when(rs.getString("test")).thenThrow(SQLException.class);
        Assertions.assertThrows(SQLException.class, () -> {
            rs.getString("test");
        });
    }
}