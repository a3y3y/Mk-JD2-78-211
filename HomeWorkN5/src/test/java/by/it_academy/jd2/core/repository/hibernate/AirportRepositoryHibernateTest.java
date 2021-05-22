package by.it_academy.jd2.core.repository.hibernate;

import by.it_academy.jd2.core.dto.Airport;
import by.it_academy.jd2.core.repository.sql.AirportRepositorySql;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AirportRepositoryHibernateTest {

    @Test
    void readAll() {
        AirportRepositoryHibernate airportRepositoryHibernate = new AirportRepositoryHibernate();
        List<Airport> test = airportRepositoryHibernate.readAll();
        Assertions.assertFalse(test.isEmpty());
    }
}