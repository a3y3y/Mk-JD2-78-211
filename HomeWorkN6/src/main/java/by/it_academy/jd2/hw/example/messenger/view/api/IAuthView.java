package by.it_academy.jd2.hw.example.messenger.view.api;

import by.it_academy.jd2.hw.example.messenger.model.User;

/**
 * Authentication interface
 * @author Maksim Perekladov
 * @version 2.0
 */

public interface IAuthView {
    User authentication(String login, String password);
}
