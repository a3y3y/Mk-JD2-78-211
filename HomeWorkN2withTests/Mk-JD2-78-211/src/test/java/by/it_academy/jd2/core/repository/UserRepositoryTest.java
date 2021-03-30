package by.it_academy.jd2.core.repository;

import by.it_academy.jd2.core.dto.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {
    UserRepository userRepository = UserRepository.getInstance();
    User user = new User("Test","test","test", "test", "test");
    @Test
    void getInstance() {
        UserRepository expected = UserRepository.getInstance();
        UserRepository actual = UserRepository.getInstance();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void addUserToRepository() {

        userRepository.addUserToRepository(user);
        Assertions.assertNotNull(userRepository);
    }

    @Test
    void getUserFromRepository() {
        userRepository.addUserToRepository(user);
        User expected = userRepository.getUserFromRepository("Test");
        User expectedEmpty = userRepository.getUserFromRepository("Tes");
        Assertions.assertNull(expectedEmpty);
        Assertions.assertEquals(expected, user);
    }

    @Test
    void testGetUserFromRepository() {
        User userExpected = userRepository.getUserFromRepository("Test", "test");
        String expected = userExpected.getLogin() + userExpected.getPassword();
        User expectedEmpty = userRepository.getUserFromRepository("Test","tes");
        String userActual = user.getLogin() + user.getPassword();
        Assertions.assertNull(expectedEmpty);
        Assertions.assertEquals(expected, userActual);
    }
    @AfterEach
    void tearDown() {
        UserRepository userRepository = null;
        User user = null;
    }
}