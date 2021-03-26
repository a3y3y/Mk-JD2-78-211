package by.it_academy.jd2.web.servlet;

import by.it_academy.jd2.core.dto.Person;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

@WebServlet(name = "DtoServlet", urlPatterns = "/dto")
public class DtoServlet extends HttpServlet {
    private Person person;
    private final String FIRST_NAME = "firstName";
    private final String LAST_NAME = "lastName";
    private final String AGE = "age";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter(FIRST_NAME);
        String lastName = req.getParameter(LAST_NAME);
        String age = req.getParameter(AGE);
        String header = req.getHeader("Storage");
        PrintWriter pw = resp.getWriter();

        if (header.equals("cookie")) {
            Cookie[] cookies = req.getCookies();
            Cookie cookie = null;
            if(cookies != null) {
                cookie = getCookieValue(req,FIRST_NAME);
            }
            if (firstName != null && lastName != null && age != null) {
                person = new Person(firstName, lastName, Integer.parseInt(age));
                saveCookie(resp, FIRST_NAME, person.getFirstName());
                saveCookie(resp, LAST_NAME, person.getLastName());
                saveCookie(resp, AGE, String.valueOf(person.getAge()));
            } else if (cookie == null) {
                throw new IllegalArgumentException("One or more parameters hasn't been transferred");
            } else {
                person = getPersonFromCookies(req);
            }

        } else if (header.equals("session")) {
            HttpSession session = req.getSession();
            if (firstName != null && lastName != null && age != null) {
                person = new Person(firstName, lastName, Integer.parseInt(age));
                saveSession(req, FIRST_NAME, person.getFirstName());
                saveSession(req, LAST_NAME, person.getLastName());
                saveSession(req, AGE, String.valueOf(person.getAge()));
            } else if (session.isNew()) {
                throw new IllegalArgumentException("One or more parameters hasn't been transferred");
            } else {
                person = getPersonFromSession(req);
            }
        } else {
            throw new IllegalArgumentException("Wrong header");
        }
        pw.write("<p><span style='color: orange;'>Person " + person.toString() + "</span></p>");
    }

    private void saveCookie(HttpServletResponse resp, String key, String val) {
        Cookie cookie = new Cookie(key, val);
        cookie.setMaxAge(Math.toIntExact(TimeUnit.DAYS.toSeconds(1)));
        resp.addCookie(cookie);
    }

    private void saveSession(HttpServletRequest req, String key, String val) {
        HttpSession session = req.getSession();
        session.setAttribute(key, val);
    }

    private Person getPersonFromCookies(HttpServletRequest req) {
        Cookie cookieFirstName = getCookieValue(req, FIRST_NAME);
        Cookie cookieLastName = getCookieValue(req, LAST_NAME);
        Cookie cookieAge = getCookieValue(req, AGE);
        return person = new Person(cookieFirstName.getValue(), cookieLastName.getValue()
                , Integer.parseInt(cookieAge.getValue()));
    }

    private Cookie getCookieValue(HttpServletRequest req, String key) {
        Cookie cookie = null;
        Cookie[] cookies = req.getCookies();
        for (Cookie c : cookies) {
            if (key.equals(c.getName())) {
                cookie = c;
                break;
            }
        }
        return cookie;
    }

    private Person getPersonFromSession(HttpServletRequest req) {
        HttpSession session = req.getSession();
        String firstName = (String) session.getAttribute(FIRST_NAME);
        String lastName = (String) session.getAttribute(LAST_NAME);
        String age = (String) session.getAttribute(AGE);

        return person = new Person(firstName, lastName, Integer.parseInt(age));
    }
}
