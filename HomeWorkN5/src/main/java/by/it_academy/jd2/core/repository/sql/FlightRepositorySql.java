package by.it_academy.jd2.core.repository.sql;


import by.it_academy.jd2.core.dto.Flight;
import by.it_academy.jd2.core.repository.FlightDao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static by.it_academy.jd2.core.util.AbstractConnection.getConnection;

/**
 * Flight repository PostgreSQL
 * @author Maksim Perekladov
 * @version 0.0
 */

public class FlightRepositorySql implements FlightDao {

    /** String with sql statement for readPartOfFlightsByDate() method. */
    private static final String READ_BY_DATE = "SELECT f.flight_no, f.scheduled_departure, \n" +
            "f.scheduled_arrival, f.status,\n" +
            "departure.airport_name ->> 'en' AS departure_airport,\n" +
            "arrival.airport_name ->> 'en' AS arrival_airport,\n" +
            "aircraft.model ->> 'en' AS aircraft_model\n" +
            "FROM bookings.flights AS f\n" +
            "JOIN bookings.aircrafts_data AS aircraft\n" +
            "ON f.aircraft_code=aircraft.aircraft_code\n" +
            "JOIN bookings.airports_data AS departure\n" +
            "ON f.departure_airport=departure.airport_code\n" +
            "JOIN bookings.airports_data AS arrival\n" +
            "ON f.arrival_airport=arrival.airport_code\n" +
            "WHERE departure.airport_name ->> 'en'=?\n" +
            "AND arrival.airport_name ->> 'en'=?\n" +
            "AND f.scheduled_departure BETWEEN ? AND ?\n" +
            "ORDER BY f.scheduled_departure ";

    /** String with sql statement for readPartOfFlightsByDate() method. */
    private static final String LIMIT_OFFSET = "OFFSET ? LIMIT ?";

    /** String with sql statement for getNumberOfStrings() method. */
    private static final String GET_NUMBER_OF_FLIGHTS = "SELECT Count(*)" +
            "FROM bookings.flights AS f\n" +
            "JOIN bookings.aircrafts_data AS aircraft\n" +
            "ON f.aircraft_code=aircraft.aircraft_code\n" +
            "JOIN bookings.airports_data AS departure\n" +
            "ON f.departure_airport=departure.airport_code\n" +
            "JOIN bookings.airports_data AS arrival\n" +
            "ON f.arrival_airport=arrival.airport_code\n" +
            "WHERE departure.airport_name ->> 'en'=?\n" +
            "AND arrival.airport_name ->> 'en'=?\n" +
            "AND f.scheduled_departure BETWEEN ? AND ?";


    /** Gets list of flights filtered by date range (from date1 to date2)
     * and arrival and departed airports from sql database.
     * @return Arraylist with Flight objects. */
    @Override
    public List<Flight> readPartOfFlightsByDate(String date1, String date2
            , String departureAirport, String arrivalAirport, int offsetStrings, int limit) {
        List<Flight> list = new ArrayList<>();
        try (PreparedStatement stmt = getConnection().prepareStatement(READ_BY_DATE + LIMIT_OFFSET)) {
            stmt.setString(1, departureAirport);
            stmt.setString(2, arrivalAirport);
            stmt.setTimestamp(3, Timestamp.valueOf(date1 + " 00:00:00.000000000"));
            stmt.setTimestamp(4, Timestamp.valueOf(date2 + " 23:59:59.000000000"));
            stmt.setInt(5, offsetStrings);
            stmt.setInt(6, limit);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Flight flight = new Flight();
                    flight.setFlightNo(rs.getString("flight_no"));
                    flight.setScheduledDeparture(rs.getString("scheduled_departure"));
                    flight.setScheduledArrival(rs.getString("scheduled_arrival"));
                    flight.setStatus(rs.getString("status"));
                    flight.setDepartureAirport(rs.getString("departure_airport"));
                    flight.setArrivalAirport(rs.getString("arrival_airport"));
                    flight.setAircraftModel(rs.getString("aircraft_model"));
                    list.add(flight);
                }
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return list;
    }

    /** Returns number of Strings from sql query READ_BY_DATE, which needs for pagination on flights.jsp page.
     *
     * @return integer value of number of String from sql statement.
     * */
    @Override
    public int getNumberOfStrings(String date1, String date2, String departureAirport, String arrivalAirport) {
        int numberOfFlights = 0;
        try (PreparedStatement stmt = getConnection().prepareStatement(GET_NUMBER_OF_FLIGHTS)) {
            stmt.setString(1, departureAirport);
            stmt.setString(2, arrivalAirport);
            stmt.setTimestamp(3, Timestamp.valueOf(date1 + " 00:00:00.000000000"));
            stmt.setTimestamp(4, Timestamp.valueOf(date2 + " 23:59:59.000000000"));
            try (ResultSet rs = stmt.executeQuery()) {
                rs.next();
                numberOfFlights = rs.getInt("count");
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return numberOfFlights;
    }
}
