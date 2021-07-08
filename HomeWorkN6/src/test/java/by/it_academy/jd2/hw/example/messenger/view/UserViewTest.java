package by.it_academy.jd2.hw.example.messenger.view;

import by.it_academy.jd2.hw.example.messenger.model.User;
import by.it_academy.jd2.hw.example.messenger.storage.api.IUserRepository;
import by.it_academy.jd2.hw.example.messenger.view.api.IMessageView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class UserViewTest {

    @Mock
    IUserRepository userRepository = Mockito.mock(IUserRepository.class);
    @Mock
    IMessageView messageView = Mockito.mock(MessageView.class);

    User signUpUser;
    User user;
    User user1;
    Date date;
    List<User> users;
    UserView userView = new UserView(userRepository, messageView);

    @BeforeEach
    private void setUp() {
        signUpUser = new User();
        user1 = new User();
        date = new Date(01,01,01);
        user = new User();
        user.setFio("test");
        user.setLogin("Exist");
        user.setPassword("password");
        user.setBirthday(date);
        user.setRegistration(date);
        signUpUser.setPassword("password");
        signUpUser.setLogin("login");
        signUpUser.setFio("fio");

        when(userRepository.existsById("WrongId")).thenReturn(false);
        when(userRepository.existsById("Exist")).thenReturn(true);
        when(userRepository.getById("Exist")).thenReturn(user);


    }
    @Test
    void get() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            userView.get("WrongId");
        });
        String expectedMessage = "Неверный логин";
        String actualMessage = exception.getMessage();
        assertTrue(expectedMessage.contains(actualMessage));
        User user1 = userView.get("Exist");
        assertEquals(user1, user);
    }

    @Test
    void signUp() {
        this.exceptionTest(user, "Пользователь с логином Exist уже сущуствует");
        userView.signUp(signUpUser);
        Mockito.verify(userRepository, Mockito.times(1)).save(signUpUser);
        Mockito.verify(messageView, Mockito.times(1))
                .addSystemMessage(signUpUser.getLogin(), "Welcome to hell");
    }

    @Test
    void exceptionLoginTest() {
        signUpUser.setLogin("");
        this.exceptionTest(signUpUser, "Логин обязателен для заполнения");
    }

    @Test
    void exceptionPasswordTest() {
        signUpUser.setPassword("");
        this.exceptionTest(signUpUser, "Пароль обязателен для заполнения");
    }

    @Test
    void exceptionFioTest() {
        signUpUser.setFio("");
        this.exceptionTest(signUpUser, "ФИО обязателен для заполнения");
    }

    @Test
    void exceptionLoginPasswordFioTest(){
        this.exceptionTest(user1, "Логин обязателен для заполнения; Пароль обязателен для заполнения; ФИО обязателен для заполнения");
    }

    void exceptionTest(User userException, String message){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            userView.signUp(userException);
        });
        String expectedMessage = message;
        String actualMessage = exception.getMessage();
        assertTrue(expectedMessage.contains(actualMessage));
    }

    @Test
    void getAll() {
        List<User> users = new ArrayList<>();
        users.add(new User());
        when(userRepository.findAll()).thenReturn(users);
        Collection users1 = userView.getAll();
        assertEquals(users, users1);
    }
}