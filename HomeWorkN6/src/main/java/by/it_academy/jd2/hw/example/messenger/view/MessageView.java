package by.it_academy.jd2.hw.example.messenger.view;

import by.it_academy.jd2.hw.example.messenger.model.Message;
import by.it_academy.jd2.hw.example.messenger.model.User;
import by.it_academy.jd2.hw.example.messenger.storage.api.IChatRepository;
import by.it_academy.jd2.hw.example.messenger.view.api.IMessageView;

import java.util.Date;
import java.util.List;


/**
 * Works with messages. Uses IChatRepository for getting and adding messages to database
 * @author Maksim Perekladov
 * @version 2.0
 */

public class MessageView implements IMessageView {

    private final IChatRepository repository;

    public MessageView(IChatRepository repository) {
        this.repository = repository;
    }

    /**
     * Gets user messages
     * @return List of messages
     */

    @Override
    public List<Message> get(User currentUser) {
      return repository.findAllBySender(currentUser.getLogin());
    }

    /**
     * Adds system message to new user
     */

    @Override
    public void addSystemMessage(String loginRecipient, String text) {
        Message message = new Message();
        message.setFrom("Evil");
        message.setSendDate(new Date());
        message.setText(text);
        message.setRecipient(loginRecipient);

        this.addMessage(message);
    }

    /**
     * Adds message to database
     */


    @Override
    public void addMessage(Message message) {
        repository.save(message);
    }
}
