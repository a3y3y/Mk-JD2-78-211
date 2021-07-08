package by.it_academy.jd2.hw.example.messenger.view;

import by.it_academy.jd2.hw.example.messenger.model.User;
import by.it_academy.jd2.hw.example.messenger.view.api.IAuthView;
import by.it_academy.jd2.hw.example.messenger.view.api.IUserView;

import java.util.Objects;

/**
 * Authenticate user
 * @author Maksim Perekladov
 * @version 2.0
 */

public class AuthView implements IAuthView {

    private final IUserView userView;

    public AuthView(IUserView userView) {
        this.userView = userView;
    }
    /**
     * Authenticate user, returns user if password and login exist and if it is correct
     * @return User user
     */
    @Override
    public User authentication(String login, String password) {
        User user = this.userView.get(login);
        if(user == null){
            return null;
        }

        if(!Objects.equals(user.getPassword(), password)){
            return null;
        }

        return user;
    }
}
