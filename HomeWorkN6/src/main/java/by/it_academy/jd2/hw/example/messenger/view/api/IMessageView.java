package by.it_academy.jd2.hw.example.messenger.view.api;

import by.it_academy.jd2.hw.example.messenger.model.Message;
import by.it_academy.jd2.hw.example.messenger.model.User;

import java.util.List;

/**
 * Message service interface
 * @author Maksim Perekladov
 * @version 2.0
 */

public interface IMessageView {
    List<Message> get(User currentUser);

    void addSystemMessage(String loginRecipient, String message);

    void addMessage(Message message);
}
