package by.it_academy.jd2.web.servlet;

import by.it_academy.jd2.core.dto.User;
import by.it_academy.jd2.core.repository.UserDao;
import by.it_academy.jd2.core.repository.list.UserRepository;
import by.it_academy.jd2.core.repository.sql.UserRepositorySql;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "SignUpServlet", urlPatterns = "/signUp")
public class SignUpServlet extends HttpServlet {

    UserDao userRepository = new UserRepositorySql();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String birthDate = req.getParameter("birthDate");
        saveSession(req, "login", login);
        saveSession(req, "password", password);
        saveSession(req, "firstName", firstName);
        saveSession(req, "lastName", lastName);
        saveSession(req, "birthDate", birthDate);
        User user = new User(login, password, firstName, lastName, birthDate);
        userRepository.addUserToRepository(user);
        String path = req.getContextPath() + "/index.jsp";
        resp.sendRedirect(path);
    }

    private void saveSession(HttpServletRequest req, String key, String val) {
        HttpSession session = req.getSession();
        session.setAttribute(key, val);
    }
}
