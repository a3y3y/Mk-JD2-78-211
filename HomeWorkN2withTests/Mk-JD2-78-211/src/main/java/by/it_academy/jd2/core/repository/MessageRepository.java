package by.it_academy.jd2.core.repository;

import by.it_academy.jd2.core.dto.Message;


import java.util.ArrayList;
import java.util.List;

public class MessageRepository {
    private static MessageRepository instance;
    private MessageRepository(){}
    public static MessageRepository getInstance(){
        if(instance == null){
            instance = new MessageRepository();
        }
        return instance;
    }

    private static List<Message> messageList = new ArrayList<>();


    public void addMessageToRepository(Message message) {
        messageList.add(message);
    }

    public List<Message> getMessagesFromRepository(String recipient) {
        List<Message> recipientMessageList = new ArrayList<>();
        for (Message m : messageList) {
            if (m.getRecipient().equals(recipient)) {
                recipientMessageList.add(m);
            }
        }
        return recipientMessageList;
    }

    @Override
    public String toString() {
        return "MessageRepository{" +
                "message=" + messageList +
                '}';
    }
}
