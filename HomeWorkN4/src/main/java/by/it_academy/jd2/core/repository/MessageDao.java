package by.it_academy.jd2.core.repository;

import by.it_academy.jd2.core.dto.Message;

import java.util.List;

public interface MessageDao {
    void addMessageToRepository(Message message);
    List<Message> getMessagesFromRepository(String recipient);
}
