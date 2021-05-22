package by.it_academy.jd2.core.repository;

import by.it_academy.jd2.core.dto.Flight;

import java.util.List;

/**
 * Flight data access object interface
 * @author Maksim Perekladov
 * @version 0.0
 */

public interface FlightDao {
    /** Returns List of flights filtered by date and airport.
     * @return ArrayList of flights
     * @param date1 - date range start
     * @param date2 - date range end
     * @param arrivalAirport - arrival airport name
     * @param departureAirport - departure airport name
     * @param limit - the number of rows returned from the sql query
     * @param offsetStrings - specifies the number of rows to skip before starting to return rows from the sql query
     */
    List<Flight> readPartOfFlightsByDate(String date1,String date2, String departureAirport
            , String arrivalAirport, int offsetStrings, int limit);

    /** Returns integer value of number of String from sql statement
     * which filters flights by date and airport.
     * @return number of rows from sql query
     * @param date1 - date range start
     * @param date2 - date range end
     * @param arrivalAirport - arrival airport name
     * @param departureAirport - departure airport name
     * */
    int getNumberOfStrings(String date1,String date2, String departureAirport, String arrivalAirport);
}
