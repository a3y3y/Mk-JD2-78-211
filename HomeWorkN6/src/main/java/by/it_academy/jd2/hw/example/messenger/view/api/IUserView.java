package by.it_academy.jd2.hw.example.messenger.view.api;

import by.it_academy.jd2.hw.example.messenger.model.User;

import java.util.Collection;

/**
 * User service interface
 * @author Maksim Perekladov
 * @version 2.0
 */

public interface IUserView {
    User get(String login);
    void signUp(User user);
    Collection<User> getAll();
}
