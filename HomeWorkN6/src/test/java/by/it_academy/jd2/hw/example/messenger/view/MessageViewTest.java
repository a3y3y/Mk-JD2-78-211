package by.it_academy.jd2.hw.example.messenger.view;

import by.it_academy.jd2.hw.example.messenger.model.Message;
import by.it_academy.jd2.hw.example.messenger.model.User;
import by.it_academy.jd2.hw.example.messenger.storage.api.IChatRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class MessageViewTest {

    @Mock
    private IChatRepository chatRepository = Mockito.mock(IChatRepository.class);

    private MessageView messageView;
    private List<Message> messageList;
    private User user;
    private Message message1;

    @BeforeEach
    private void setUp(){
        Message message = new Message();
        messageList = new ArrayList<>();
        messageList.add(message);
        user = new User();
        user.setLogin("Test");
        message1 = new Message();
        message1.setFrom("Evil");
        message1.setSendDate(new Date());
        message1.setText("test message");
        message1.setRecipient("Test");
        when(chatRepository.findAllBySender("Test")).thenReturn(messageList);
        when(chatRepository.save(new Message())).thenReturn(message1);
        when(chatRepository.save(message1)).thenReturn(message1);
        messageView = new MessageView(chatRepository);


    }

    @Test
    void get() {
        assertEquals(messageList, messageView.get(user));
    }

    @Test
    void addSystemMessage() {
        messageView.addSystemMessage("Test", "test message");
        assertEquals("Evil", message1.getFrom());
        assertEquals("test message", message1.getText());
        assertEquals("Test", message1.getRecipient());

    }

    @Test
    void addMessage() {
        messageView.addMessage(message1);
        Mockito.verify(chatRepository, Mockito.times(1)).save(message1);
    }
}