package by.it_academy.jd2.web.servlet;

import by.it_academy.jd2.core.dto.Flight;
import by.it_academy.jd2.core.repository.FlightDao;
import by.it_academy.jd2.core.repository.hibernate.FlightRepositoryHibernate;
import by.it_academy.jd2.core.repository.sql.FlightRepositorySql;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

/**
 * Flights list page servlet
 * @author Maksim Perekladov
 * @version 0.0
 */

@WebServlet(name = "FlightsServlet", urlPatterns = "/flights")
public class FlightsServlet extends HttpServlet {

    /** Creates object which implements FlightDao and works with database. */
    FlightDao flightDao = new FlightRepositoryHibernate();

    private String date1;
    private String date2;
    private String departureAirport;
    private String arrivalAirport;

    /** Prepares data necessary for pagination on flights.jsp page and forwards user to flights.jsp. */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("dateDeparture1") != null && req.getParameter("dateDeparture2") != null
                && req.getParameter("departureAirport") != null && req.getParameter("arrivalAirport") != null) {
            date1 = req.getParameter("dateDeparture1");
            date2 = req.getParameter("dateDeparture2");
            departureAirport = req.getParameter("departureAirport");
            arrivalAirport = req.getParameter("arrivalAirport");
        }

        int page = 1;
        int recordsPerPage = 25;
        if (req.getParameter("page") != null) {
            page = Integer.parseInt(req.getParameter("page"));
        }
        List<Flight> flightList = flightDao.readPartOfFlightsByDate(date1, date2, departureAirport
                , arrivalAirport, (page - 1) * recordsPerPage, recordsPerPage);
        int noOfRecords = flightDao.getNumberOfStrings(date1, date2, departureAirport, arrivalAirport);
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
        req.setAttribute("flightList", flightList);
        req.setAttribute("noOfPages", noOfPages);
        req.setAttribute("currentPage", page);
        req.getRequestDispatcher("flights.jsp").forward(req, resp);
    }
}
