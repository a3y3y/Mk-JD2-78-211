package by.it_academy.jd2.core.repository.hibernate;

import by.it_academy.jd2.core.dto.Airport;
import by.it_academy.jd2.core.repository.AirportDao;
import by.it_academy.jd2.core.util.HibernateCreator;
import org.hibernate.Session;


import java.util.ArrayList;
import java.util.List;

/**
 * Gets airports information from sql database. Works with Hibernate.
 * @author Maksim Perekladov
 * @version 0.0
 */

public class AirportRepositoryHibernate implements AirportDao {

    /** Creates hibernate session object. */
    Session session = HibernateCreator.getInstance().openSession();

    /** Gets all airport info from database with Hibernate. Creates airport objects
     * with info from database and adds it in a List.
     *
     * @return ArrayList of all Airport objects
     * */
    @Override
    public List<Airport> readAll() {
        List<Airport> list = new ArrayList<>();
        String sql = "select airport_code, airport_name->>'ru' as airport_name," +
                " city->>'ru' as city, cast(coordinates as text), timezone from airports_data";
        list = session.createSQLQuery(sql).addEntity(Airport.class).list();
        return list;
    }
}
