package by.it_academy.jd2.core.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlightTest {
    Flight flight = new Flight();
    Airport airport = new Airport();
    {
        flight.setId(1);
        flight.setArrivalAirportObject(airport);
        flight.setDepartureAirportObject(airport);
        flight.setFlightNo("test");
        flight.setScheduledDeparture("test");
        flight.setScheduledDeparture("test");
        flight.setScheduledArrival("test");
        flight.setStatus("test");
        flight.setDepartureAirport("test");
        flight.setArrivalAirport("test");
        flight.setAircraftModel("test");
    }
    @Test
    void getFlightNo() {
        String test = flight.getFlightNo();
        Assertions.assertEquals(test, "test");
    }

    @Test
    void getScheduledDeparture() {
        String test = flight.getScheduledDeparture();
        Assertions.assertEquals(test, "test");
    }

    @Test
    void getScheduledArrival() {
        String test = flight.getScheduledArrival();
        Assertions.assertEquals(test, "test");
    }

    @Test
    void getStatus() {
        String test = flight.getStatus();
        Assertions.assertEquals(test, "test");
    }

    @Test
    void getDepartureAirport() {
        String test = flight.getDepartureAirport();
        Assertions.assertEquals(test, "test");
    }

    @Test
    void getArrivalAirport() {
        String test = flight.getArrivalAirport();
        Assertions.assertEquals(test, "test");
    }

    @Test
    void getAircraftModel() {
        String test = flight.getAircraftModel();
        Assertions.assertEquals(test, "test");
    }

    @Test
    public void getDepartureAirportObject(){
        Airport airport1 = flight.getDepartureAirportObject();
        assertEquals(airport1, airport);
    }

    @Test
    public void getArrivalAirportObject(){
        Airport airport1 = flight.getArrivalAirportObject();
        assertEquals(airport1, airport);
    }

    @Test
    public void getId() {
        int id = flight.getId();
        assertEquals(1, id);
    }

    @Test
    public void testToString() {
        assertEquals("Flight{flightNo='test', scheduledDeparture='test', " +
                "scheduledArrival='test', status='test', departureAirport='test', " +
                "arrivalAirport='test', aircraftModel='test'}", flight.toString());
    }
}