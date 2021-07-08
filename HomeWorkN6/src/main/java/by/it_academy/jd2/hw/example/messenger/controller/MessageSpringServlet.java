package by.it_academy.jd2.hw.example.messenger.controller;

import by.it_academy.jd2.hw.example.messenger.model.Message;
import by.it_academy.jd2.hw.example.messenger.model.User;
import by.it_academy.jd2.hw.example.messenger.storage.api.IChatRepository;
import by.it_academy.jd2.hw.example.messenger.view.api.IMessageView;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Process users requests related with messages
 * @author Maksim Perekladov
 * @version 2.0
 */

@Controller
@SessionAttributes(value = "user")
public class MessageSpringServlet {
    private final IChatRepository repository;
    private final IMessageView messageView;

    public MessageSpringServlet(IMessageView messageView, IChatRepository repository) {
        this.messageView = messageView;
        this.repository = repository;
    }

    @GetMapping("/message")
    protected String getMessagePage(){
        return "/views/message.jsp";
    }

    @GetMapping("/chats")
    protected String viewChat(@SessionAttribute(name = "user") User user, Model model){
        if(user == null){
            throw new SecurityException("Ошибка безопасности");
        }
        model.addAttribute("chat", repository.findAllBySender(user.getLogin()));
        return "/views/chats.jsp";
    }

    @PostMapping("/message")
    protected String sendMessage(@SessionAttribute(name = "user") User user,
                                 @RequestParam(name = "recipient") String recipient,
                                 @RequestParam(name = "text") String text, Model model){
        if(user == null){
            throw new SecurityException("Ошибка безопасности");
        }
        Message message = new Message();
        message.setFrom(user.getLogin());
        message.setSendDate(new Date());
        message.setText(text);
        message.setRecipient(recipient);

        try{
            this.messageView.addMessage(message);
            model.addAttribute("success", true);
        } catch (IllegalArgumentException e){
            model.addAttribute("error", true);
            model.addAttribute("message",  e.getMessage());
        }

        return "/views/message.jsp";
    }
}
