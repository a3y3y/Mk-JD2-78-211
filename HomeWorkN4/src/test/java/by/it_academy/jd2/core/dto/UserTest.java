package by.it_academy.jd2.core.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User user = new User();
    {
        user.setFirstName("test");
        user.setLastName("test");
        user.setBirthDate("test");
    }

    @Test
    void getFirstName() {
        String test = user.getFirstName();
        Assertions.assertEquals(test, "test");
    }

    @Test
    void getLastName() {
        String test = user.getLastName();
        Assertions.assertEquals(test, "test");
    }

    @Test
    void getBirthDate() {
        String test = user.getBirthDate();
        Assertions.assertEquals(test, "test");
    }
}