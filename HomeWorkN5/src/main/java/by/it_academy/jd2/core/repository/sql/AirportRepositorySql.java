package by.it_academy.jd2.core.repository.sql;

import by.it_academy.jd2.core.dto.Airport;
import by.it_academy.jd2.core.repository.AirportDao;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.it_academy.jd2.core.util.AbstractConnection.getConnection;

/**
 * Airport repository working with PostgreSQL
 * @author Maksim Perekladov
 * @version 0.0
 */


public class AirportRepositorySql implements AirportDao {
    /** String with SQL statement for readAll() method */
    private static final String READ_ALL = "SELECT * FROM bookings.airports_data ORDER BY city";
    /**
     * Gets list of all airports from database.
     * @return Arraylist with Airport objects, if there is no airports in database, returns
     * empty List.
     */
    @Override
    public List<Airport> readAll() {
        List<Airport> list = new ArrayList<>();
        try (PreparedStatement stmt = getConnection().prepareStatement(READ_ALL);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Airport airport = new Airport();
                airport.setCode(rs.getString("airport_code"));
                Object obj = new JSONParser().parse(rs.getString("airport_name"));
                JSONObject jsonName = (JSONObject) obj;
                airport.setName((String) jsonName.get("en"));
                Object obj1 = new JSONParser().parse(rs.getString("city"));
                JSONObject jsonCity = (JSONObject) obj1;
                airport.setCity((String) jsonCity.get("en"));
                airport.setCoordinates(rs.getString("coordinates"));
                airport.setTimezone(rs.getString("timezone"));
                list.add(airport);
            }
        } catch (SQLException e){
            e.getMessage();
        } catch (ParseException e) {
            e.getMessage();
        }
        return list;
    }
}
