package by.it_academy.jd2.core.repository.hibernate;

import by.it_academy.jd2.core.dto.Flight;
import by.it_academy.jd2.core.repository.sql.FlightRepositorySql;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FlightRepositoryHibernateTest {

    FlightRepositoryHibernate flightRepositoryHibernate = new FlightRepositoryHibernate();
    private String date1 = "2016-08-15";
    private String date2 = "2017-09-14";
    private String departureAirport = "Домодедово";
    private String arrivalAirport = "Пулково";
    private List<Flight> flights = new ArrayList<>();
    private Flight flight = new Flight("test", "test", "test", "test", "test",
            "test", "test");

    {
        flights.add(flight);
    }

    @Test
    void readPartOfFlightsByDate() {
        List<Flight> testList = flightRepositoryHibernate.readPartOfFlightsByDate(date1, date2, departureAirport
                , arrivalAirport, 0, 25);
        Assertions.assertFalse(testList.isEmpty());
    }

    @Test
    void getNumberOfStrings() {
        int test = flightRepositoryHibernate.getNumberOfStrings(date1, date2, departureAirport, arrivalAirport);
        Assertions.assertTrue(test > 0);
    }
}