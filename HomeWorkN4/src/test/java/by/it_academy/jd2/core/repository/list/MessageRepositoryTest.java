package by.it_academy.jd2.core.repository.list;

import by.it_academy.jd2.core.dto.Message;
import by.it_academy.jd2.core.repository.list.MessageRepository;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

class MessageRepositoryTest {
    MessageRepository messageRepository = MessageRepository.getInstance();
    Message message = new Message();

    {
        message.setMessageText("Test");
        message.setRecipient("Test");
        message.setSender("Test");
        message.setSendTime();
    }

    @Test
    void getInstance() {
        MessageRepository actual = MessageRepository.getInstance();
        Assertions.assertEquals(messageRepository, actual);
    }

    @Test
    void addMessageToRepository() {
        List<Message> messagesList = new ArrayList<>();
        messagesList.add(message);
        String expected = "MessageRepository{" +
                "message=" + messagesList +
                '}';
        Assertions.assertEquals(expected,messageRepository.toString());
    }

    @Test
    void getMessagesFromRepository() {
        messageRepository.addMessageToRepository(message);
        List<Message> expected = messageRepository.getMessagesFromRepository("Test");
        List<Message> empty = messageRepository.getMessagesFromRepository("Tes");
        List<Message> actual = new ArrayList<>();
        Assertions.assertEquals(empty, actual);
        actual.add(message);
        Assertions.assertEquals(expected, actual);
    }

    @AfterEach
    void tearDown() {
        messageRepository = null;
    }
}