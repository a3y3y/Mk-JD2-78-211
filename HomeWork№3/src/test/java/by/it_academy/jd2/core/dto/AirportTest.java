package by.it_academy.jd2.core.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AirportTest {

    Airport airport = new Airport();
    Airport airport1 = new Airport();

    {
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
        Assertions.assertEquals(name, "test");
    }

    @Test
    public void getCode() {
        String name = airport.getCode();
        Assertions.assertEquals(name, "test");
    }

    @Test
    public void getCity() {
        String name = airport.getCity();
        Assertions.assertEquals(name, "test");
    }

    @Test
    public void getCoordinates() {
        String name = airport.getCoordinates();
        Assertions.assertEquals(name, "test");
    }

    @Test
    public void getTimezone() {
        String name = airport.getTimezone();
        Assertions.assertEquals(name, "test");
    }

    @Test
    public void compareTo(){
        Assertions.assertEquals(0, airport.compareTo(airport1));
    }

}