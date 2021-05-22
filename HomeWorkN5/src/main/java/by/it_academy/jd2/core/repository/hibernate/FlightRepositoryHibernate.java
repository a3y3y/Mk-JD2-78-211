package by.it_academy.jd2.core.repository.hibernate;


import by.it_academy.jd2.core.dto.Flight;
import by.it_academy.jd2.core.repository.FlightDao;
import by.it_academy.jd2.core.util.HibernateCreator;
import org.hibernate.Session;

import javax.persistence.Query;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Gets flights information from sql database. Works with Hibernate.
 * @author Maksim Perekladov
 * @version 0.0
 */

public class FlightRepositoryHibernate implements FlightDao {

    /** Creates hibernate session object. */
    Session session = HibernateCreator.getInstance().openSession();

    /** String with sql statement for readPartOfFlightsByDate() method. */
    private static final String READ_BY_DATE = "SELECT f.flight_no, cast(f.scheduled_departure as text), \n" +
            "cast (f.scheduled_arrival as text), f.status,\n" +
            "departure.airport_name ->> 'ru' AS departure_airport,\n" +
            "arrival.airport_name ->> 'ru' AS arrival_airport,\n" +
            "aircraft.model ->> 'ru' AS aircraft_model\n" +
            "FROM bookings.flights AS f\n" +
            "JOIN bookings.aircrafts_data AS aircraft\n" +
            "ON f.aircraft_code=aircraft.aircraft_code\n" +
            "JOIN bookings.airports_data AS departure\n" +
            "ON f.departure_airport=departure.airport_code\n" +
            "JOIN bookings.airports_data AS arrival\n" +
            "ON f.arrival_airport=arrival.airport_code\n" +
            "WHERE departure.airport_name ->> 'ru'= :dep\n" +
            "AND arrival.airport_name ->> 'ru'= :arr\n" +
            "AND cast(f.scheduled_departure as text) BETWEEN :start AND :end\n" +
            "ORDER BY cast(f.scheduled_departure as text) ";

    /** String with sql statement for readPartOfFlightsByDate() method. */
    private static final String LIMIT_OFFSET = "OFFSET :offsetStrings LIMIT :limit";

    /** String with sql statement for getNumberOfStrings() method. */
    private static final String GET_NUMBER_OF_FLIGHTS = "SELECT Count(*)" +
            "FROM bookings.flights AS f\n" +
            "JOIN bookings.airports_data AS departure\n" +
            "ON f.departure_airport=departure.airport_code\n" +
            "JOIN bookings.airports_data AS arrival\n" +
            "ON f.arrival_airport=arrival.airport_code\n" +
            "WHERE departure.airport_name ->> 'ru'=:dep\n" +
            "AND arrival.airport_name ->> 'ru'=:arr\n" +
            "AND cast(f.scheduled_departure as text) BETWEEN :start AND :end";

    /** Gets list of flights filtered by date range (from date1 to date2)
     * and arrival and departed airports from sql database.
     * @return Arraylist with Flight objects. */

    @Override
    public List<Flight> readPartOfFlightsByDate(String date1, String date2, String departureAirport,
                                                String arrivalAirport, int offsetStrings, int limit) {
        List<Flight> list = new ArrayList<>();
        Query query = session.createNativeQuery(READ_BY_DATE + LIMIT_OFFSET,"FlightResult");
        query.setParameter("dep", departureAirport);
        query.setParameter("arr", arrivalAirport);
        query.setParameter("start", date1 + " 00:00:00.000000000");
        query.setParameter("end", date2 + " 23:59:59.000000000");
        query.setParameter("offsetStrings", offsetStrings);
        query.setParameter("limit", limit);
        list = query.getResultList();
        return list;
    }

    /** Returns number of Strings from sql query READ_BY_DATE, which needs for pagination on flights.jsp page.
     *
     * @return integer value of number of String from sql statement.
     * */
    @Override
    public int getNumberOfStrings(String date1, String date2, String departureAirport, String arrivalAirport) {
        Query query = session.createSQLQuery(GET_NUMBER_OF_FLIGHTS);
        query.setParameter("dep", departureAirport);
        query.setParameter("arr", arrivalAirport);
        query.setParameter("start", date1 + " 00:00:00.000000000");
        query.setParameter("end", date2 + " 23:59:59.000000000");
        BigInteger bigInteger = (BigInteger) query.getSingleResult();
        return bigInteger.intValue();
    }
}
