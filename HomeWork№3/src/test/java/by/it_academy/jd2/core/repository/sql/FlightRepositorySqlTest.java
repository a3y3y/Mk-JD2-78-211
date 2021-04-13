package by.it_academy.jd2.core.repository.sql;

import by.it_academy.jd2.core.dto.Airport;
import by.it_academy.jd2.core.dto.Flight;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FlightRepositorySqlTest {

    FlightRepositorySql flightRepositorySql = new FlightRepositorySql();
    String date1 = "2016-08-15";
    String date2 = "2017-09-14";
    String departureAirport = "Domodedovo International Airport";
    String arrivalAirport = "Yelizovo Airport";

    @Test
    public void readPartOfFlightsByDate() {
        List<Flight> test = flightRepositorySql.readPartOfFlightsByDate(date1, date2, departureAirport
                , arrivalAirport,0, 25);
        Assertions.assertFalse(test.isEmpty());

//        Throwable thrown = assertThrows(SQLException.class, ()->{List<Flight> test1 = flightRepositorySql
//                .readPartOfFlightsByDate(date1, date2, departureAirport
//                , "SELECT",0, -25);});
//        assertNotNull(thrown.getMessage());
    }

    @Test
    public void getNumberOfStrings() {
        int test = flightRepositorySql.getNumberOfStrings(date1, date2, departureAirport, arrivalAirport);
                Assertions.assertTrue(test > 0);
                //        Throwable thrown = assertThrows(SQLException.class, ()->{List<Flight> test1 = flightRepositorySql
//                .readPartOfFlightsByDate(date1, date2, departureAirport
//                , "SELECT",0, -25);});
//        assertNotNull(thrown.getMessage());
    }
}