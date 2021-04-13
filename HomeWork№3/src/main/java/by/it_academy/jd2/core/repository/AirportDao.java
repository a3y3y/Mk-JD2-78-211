package by.it_academy.jd2.core.repository;

import by.it_academy.jd2.core.dto.Airport;

import java.util.List;

/**
 * Airport data access object interface
 * @author Maksim Perekladov
 * @version 0.0
 */

public interface AirportDao {
    List<Airport> readAll();
}
