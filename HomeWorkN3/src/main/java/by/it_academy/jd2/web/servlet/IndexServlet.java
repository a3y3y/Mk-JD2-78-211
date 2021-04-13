package by.it_academy.jd2.web.servlet;

import by.it_academy.jd2.core.dto.Airport;
import by.it_academy.jd2.core.repository.AirportDao;
import by.it_academy.jd2.core.repository.sql.AirportRepositorySql;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * Welcome page servlet
 * @author Maksim Perekladov
 * @version 0.0
 */

@WebServlet(name = "IndexServlet", urlPatterns = "")
public class IndexServlet extends HttpServlet {
    AirportDao airportDao = new AirportRepositorySql();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Airport> airportList = airportDao.readAll();
        Collections.sort(airportList);
        req.setAttribute("airportList", airportList);
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
