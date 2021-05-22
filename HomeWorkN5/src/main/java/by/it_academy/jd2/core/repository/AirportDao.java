package by.it_academy.jd2.core.repository;

import by.it_academy.jd2.core.dto.Airport;

import java.util.List;

/**
 * Airport data access object interface
 * @author Maksim Perekladov
 * @version 0.0
 */

public interface AirportDao {

    /** Returns list of all airports in database.
     * @return ArrayList with Airport objects
     */
    List<Airport> readAll();
}
