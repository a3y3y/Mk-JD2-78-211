package by.it_academy.jd2.hw.example.messenger.view;

import by.it_academy.jd2.hw.example.messenger.model.User;
import by.it_academy.jd2.hw.example.messenger.view.api.IUserView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class AuthViewTest {

    @Mock
    IUserView userViewMock = Mockito.mock(UserView.class);

    AuthView authView;
    User user;
    User user1;

    @BeforeEach
    public void setUp() {
        user = new User();
        user.setLogin("Test");
        user.setPassword("test");
        Mockito.when(userViewMock.get("Test")).thenReturn(user);
        Mockito.when(userViewMock.get("Null")).thenReturn(user1);
        authView = new AuthView(userViewMock);
    }


    @Test
    void authentication() {
        assertEquals(user, authView.authentication("Test", "test"));
        assertEquals(null, authView.authentication("Test", "wrong"));
        assertEquals(null, authView.authentication("Null", "test"));
    }
}