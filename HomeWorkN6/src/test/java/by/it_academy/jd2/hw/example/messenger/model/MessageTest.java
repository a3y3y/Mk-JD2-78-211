package by.it_academy.jd2.hw.example.messenger.model;

import by.it_academy.jd2.hw.example.messenger.view.MessageView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class MessageTest {

    Message message;
    Date date;

    @BeforeEach
    private void setUp() {
        message = new Message();
        message.setFrom("Evil");
        message.setSendDate(new Date());
        message.setText("test message");
        message.setRecipient("Test");
        message.setId(1L);
        date = new Date(01,01,01);
        message.setSendDate(date);
    }

    @Test
    void getId() {
        assertEquals(1L, message.getId());
    }

    @Test
    void getSendDate() {
        assertEquals(date, message.getSendDate());
    }
}