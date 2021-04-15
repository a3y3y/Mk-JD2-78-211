package by.it_academy.jd2.core.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MessageTest {
    Message message = new Message();

    {
        message.setMessageText("test");
        message.setRecipient("test");
        message.setSender("test");
        message.setSendTime("test");
    }

    @Test
    void getSender() {
        String test = message.getSender();
        Assertions.assertEquals(test, "test");
    }

    @Test
    void getMessageText() {
        String test = message.getMessageText();
        Assertions.assertEquals(test, "test");
    }

    @Test
    void getSendTime() {
        String test = message.getSendTime();
        Assertions.assertEquals(test, "test");
    }

    @Test
    void setSendTime() {
        message.setSendTime("test");
        Assertions.assertEquals(message.getSendTime(), "test");
    }
}