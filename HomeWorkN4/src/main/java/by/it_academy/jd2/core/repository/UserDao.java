package by.it_academy.jd2.core.repository;

import by.it_academy.jd2.core.dto.User;

public interface UserDao {
    void addUserToRepository(User user);
    User getUserFromRepository(String login);
    User getUserFromRepository(String login, String password);
}
