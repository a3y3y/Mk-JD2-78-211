package by.it_academy.jd2.core.repository;

import by.it_academy.jd2.core.dto.Flight;

import java.util.List;

/**
 * Flight data access object interface
 * @author Maksim Perekladov
 * @version 0.0
 */

public interface FlightDao {
    List<Flight> readPartOfFlightsByDate(String date1,String date2, String departureAirport
            , String arrivalAirport, int offsetStrings, int limit);

    int getNumberOfStrings(String date1,String date2, String departureAirport, String arrivalAirport);
}
