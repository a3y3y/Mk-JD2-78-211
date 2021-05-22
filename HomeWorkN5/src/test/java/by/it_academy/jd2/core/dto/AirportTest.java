package by.it_academy.jd2.core.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AirportTest {

    Airport airport = new Airport();
    Airport airport1 = new Airport();
    Flight flight = new Flight();
    Set<Flight> flightSet = new HashSet<>();
    Set<Flight> test = new HashSet<>();

    {
        flightSet.add(flight);
        airport.setArrivalFlights(flightSet);
        airport.setDepartureFlights(flightSet);
        airport.setName("test");
        airport.setCode("test");
        airport.setCity("test");
        airport.setCoordinates("test");
        airport.setTimezone("test");

        airport1.setName("test");
        airport1.setCode("test");
        airport1.setCity("test");
        airport1.setCoordinates("test");
        airport1.setTimezone("test");
    }

    @Test
    public void getName() {
        String name = airport.getName();
        assertEquals(name, "test");
    }

    @Test
    public void getCode() {
        String name = airport.getCode();
        assertEquals(name, "test");
    }

    @Test
    public void getCity() {
        String name = airport.getCity();
        assertEquals(name, "test");
    }

    @Test
    public void getCoordinates() {
        String name = airport.getCoordinates();
        assertEquals(name, "test");
    }

    @Test
    public void getTimezone() {
        String name = airport.getTimezone();
        assertEquals(name, "test");
    }

    @Test
    public void getDepartureFlights() {
        test = airport.getDepartureFlights();
        assertEquals(flightSet, test);
    }

    @Test
    public void getArrivalFlights() {
        test = airport.getArrivalFlights();
        assertEquals(flightSet, test);
    }

    @Test
    public void compareTo() {
        assertEquals(0, airport.compareTo(airport1));
    }

    @Test
    public void testToString() {
        assertEquals("Airport{" +
                "code='test\', name='test\', city='test\', coordinates='test\'," +
                " timezone='test\'}", airport.toString());
    }

}