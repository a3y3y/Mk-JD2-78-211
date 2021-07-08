package by.it_academy.jd2.hw.example.messenger.view;

import by.it_academy.jd2.hw.example.messenger.model.User;
import by.it_academy.jd2.hw.example.messenger.storage.api.IUserRepository;
import by.it_academy.jd2.hw.example.messenger.view.api.IMessageView;
import by.it_academy.jd2.hw.example.messenger.view.api.IUserView;

import java.util.Collection;
import java.util.Date;

/**
 * Works with users. Uses IUserRepository for getting and adding users to database
 * @author Maksim Perekladov
 * @version 2.0
 */

public class UserView implements IUserView {

    private final IUserRepository userRepository;
    private final IMessageView messageView;

    public UserView(IUserRepository userRepository, IMessageView messageView) {
        this.userRepository = userRepository;
        this.messageView = messageView;
    }
    /**
     * Gets user from database by login if such a user exists
     * @throws IllegalArgumentException if login is wrong
     * @return List of messages
     */

    @Override
    public User get(String login) {
        if (!userRepository.existsById(login)) {
            throw new IllegalArgumentException("Неверный логин");
        } else {
            return this.userRepository.getById(login);
        }
    }

    /**
     * Saves user to database
     */

    @Override
    public void signUp(User user) {
        this.validationForSignUp(user);
        user.setRegistration(new Date());
        this.userRepository.save(user);

        this.messageView.addSystemMessage(user.getLogin(), "Welcome to hell");
    }

    /**
     * Checks if all information is correct and also checks if user with such login doesn't exist
     * @throws IllegalArgumentException if login, password or fio are empty or such login exists
     */

    private void validationForSignUp(User user) {
        String errorMessage = "";
        if (this.nullOrEmpty(user.getLogin())) {
            errorMessage += "Логин обязателен для заполнения";
        }
        if (this.nullOrEmpty(user.getPassword())) {
            if (!errorMessage.isEmpty()) {
                errorMessage += "; ";
            }
            errorMessage += "Пароль обязателен для заполнения";
        }
        if (this.nullOrEmpty(user.getFio())) {
            if (!errorMessage.isEmpty()) {
                errorMessage += "; ";
            }
            errorMessage += "ФИО обязателен для заполнения";
        }

        if (!errorMessage.isEmpty()) {
            throw new IllegalArgumentException(errorMessage);
        }
        if (userRepository.getById(user.getLogin()) != null) {
            throw new IllegalArgumentException("Пользователь с логином " + user.getLogin() + " уже сущуствует");
        }
    }

    /**
     * Checks if String null or empty
     */

    private boolean nullOrEmpty(String val) {
        return val == null || val.isEmpty();
    }

    /**
     * Gets all users from database
     * @return Collection of Users
     */

    @Override
    public Collection<User> getAll() {
        return this.userRepository.findAll();
    }
}
