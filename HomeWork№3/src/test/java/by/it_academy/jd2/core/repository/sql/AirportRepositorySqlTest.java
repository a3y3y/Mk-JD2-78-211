package by.it_academy.jd2.core.repository.sql;

import by.it_academy.jd2.core.dto.Airport;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AirportRepositorySqlTest {

    AirportRepositorySql airportRepositorySql = new AirportRepositorySql();

    @Test
    public void readAll() {
       List<Airport> test = airportRepositorySql.readAll();
       Assertions.assertFalse(test.isEmpty());
    }
}