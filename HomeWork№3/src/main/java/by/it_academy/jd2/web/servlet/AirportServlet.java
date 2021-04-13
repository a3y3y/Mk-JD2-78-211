package by.it_academy.jd2.web.servlet;

import by.it_academy.jd2.core.dto.Airport;
import by.it_academy.jd2.core.repository.sql.AirportRepositorySql;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

/**
 * Airport list page servlet
 * @author Maksim Perekladov
 * @version 0.0
 */

@WebServlet (name = "AirportServlet", urlPatterns = "/airports")
public class AirportServlet extends HttpServlet {

    AirportRepositorySql airportDao = new AirportRepositorySql();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Airport> airportList = airportDao.readAll();
        req.setAttribute("airportList", airportList);
        req.getRequestDispatcher("airports.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
