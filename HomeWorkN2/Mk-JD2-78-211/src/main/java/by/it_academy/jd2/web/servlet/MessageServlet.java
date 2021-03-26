package by.it_academy.jd2.web.servlet;

import by.it_academy.jd2.core.dto.Message;
import by.it_academy.jd2.core.dto.User;
import by.it_academy.jd2.core.repository.MessageRepository;
import by.it_academy.jd2.core.repository.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MessageServlet", urlPatterns = "/message")
public class MessageServlet extends HttpServlet {
    MessageRepository messageRepository = MessageRepository.getInstance();
    UserRepository userRepository = UserRepository.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Message message = new Message();
        PrintWriter writer = resp.getWriter();
        HttpSession session = req.getSession();
        String recipient = req.getParameter("recipient");
        if (recipientCheck(recipient)) {
            String messageText = req.getParameter("messageText");
            String sender = (String) session.getAttribute("login");
            message.setRecipient(recipient);
            message.setMessageText(messageText);
            message.setSendTime();
            message.setSender(sender);
            messageRepository.addMessageToRepository(message);
            writer.write("<p><span style='color: green;'>Your message has been sent</span></p>" +
                    "<form action=\"chatsMessages.jsp\" method=\"GET\"> " +
                    "<input type=\"submit\" value=\"Back\"/></p> " +
                    "</form>");
        }else writer.write("<p><span style='color: red;'>User " + recipient + " doesn't exist</span></p>" +
                "<form action=\"chatsMessages.jsp\" method=\"GET\"> " +
                "<input type=\"submit\" value=\"Back\"/></p> " +
                "</form>");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    private boolean recipientCheck(String recipient){
        User user = null;
        user = userRepository.getUserFromRepository(recipient);
        if (user == null){
            return false;
        } else return true;
    }

}
