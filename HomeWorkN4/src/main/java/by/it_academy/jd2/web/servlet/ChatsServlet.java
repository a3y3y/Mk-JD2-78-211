package by.it_academy.jd2.web.servlet;


import by.it_academy.jd2.core.repository.MessageDao;
import by.it_academy.jd2.core.repository.list.MessageRepository;
import by.it_academy.jd2.core.repository.sql.MessageRepositorySql;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet (name = "ChatsServlet", urlPatterns = "/chats")
public class ChatsServlet extends HttpServlet {
    MessageDao messageRepository = new MessageRepositorySql();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String recipient = (String) session.getAttribute("login");
        req.setAttribute("mlist", messageRepository.getMessagesFromRepository(recipient));
        req.getRequestDispatcher("chats.jsp").forward(req,resp);
    }
}
