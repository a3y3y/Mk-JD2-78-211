package by.it_academy.jd2.web.servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;



@WebServlet(name = "SessionServlet", urlPatterns = "/session")
public class SessionServlet extends HttpServlet {
    private static final String FIRST_NAME_PARAM_NAME = "firstName";
    private static final String LAST_NAME_PARAM_NAME = "lastName";

    public void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        String firstNameVal = getValueFromAnywhere(req, FIRST_NAME_PARAM_NAME);
        saveSession(req, FIRST_NAME_PARAM_NAME, firstNameVal);

        String lastNameVal = getValueFromAnywhere(req, LAST_NAME_PARAM_NAME);
        saveSession(req, LAST_NAME_PARAM_NAME, lastNameVal);

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.write("<p><span style='color: blue;'>Hello, " + lastNameVal + " " + firstNameVal + "!</span></p>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    public static String getValueFromAnywhere(HttpServletRequest req, String key){
        String val = req.getParameter(key);

        if(val == null){
            HttpSession session = req.getSession();

            if(!session.isNew()){
                val = (String) session.getAttribute(key);
            }
        }

        if(val == null){
            throw new IllegalArgumentException("One or more parameters hasn't been transferred");
        }
        return val;
    }

    public static void saveSession(HttpServletRequest req, String key, String val){
        HttpSession session = req.getSession();
        session.setAttribute(key, val);
    }
}