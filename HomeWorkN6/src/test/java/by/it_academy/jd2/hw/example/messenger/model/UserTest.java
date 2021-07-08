package by.it_academy.jd2.hw.example.messenger.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    User user;
    Date date;

    @BeforeEach
    void setUp() {
        date = new Date(01, 01, 01);
        user = new User();
        user.setFio("test");
        user.setLogin("Exist");
        user.setPassword("password");
        user.setBirthday(date);
        user.setRegistration(date);
    }

    @Test
    void testToString() {
        assertEquals("User{login='Exist', password='password', fio='test'," +
                " birthday=Fri Feb 01 00:00:00 MSK 1901, " +
                "registration=Fri Feb 01 00:00:00 MSK 1901}", user.toString());
    }




    @Test
    void getLogin() {
        assertEquals("Exist", user.getLogin());
    }

    @Test
    void getFio() {
        assertEquals("test", user.getFio());
    }

    @Test
    void getBirthday() {
        assertEquals(date, user.getBirthday());
    }

    @Test
    void getRegistration() {
        assertEquals(date, user.getRegistration());
    }
}