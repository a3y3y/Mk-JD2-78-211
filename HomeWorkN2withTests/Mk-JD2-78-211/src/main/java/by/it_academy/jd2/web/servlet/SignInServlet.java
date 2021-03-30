package by.it_academy.jd2.web.servlet;

import by.it_academy.jd2.core.dto.User;
import by.it_academy.jd2.core.repository.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SignInServlet", urlPatterns = "/signIn")
public class SignInServlet extends HttpServlet {

    UserRepository userRepository = UserRepository.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userRepository.getUserFromRepository(req.getParameter("login")
                , req.getParameter("password"));
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        if (user == null) {
            writer.write("<p><span style='color: red;'>Oops, wrong password or login</span></p>");
        } else {
            HttpSession session = req.getSession();
            session.setAttribute("login", user.getLogin());
            String path = req.getContextPath() + "/chatsMessages.jsp";
            resp.sendRedirect(path);
        }
    }
}
