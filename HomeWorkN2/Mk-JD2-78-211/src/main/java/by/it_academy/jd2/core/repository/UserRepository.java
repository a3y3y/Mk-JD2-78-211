package by.it_academy.jd2.core.repository;

import by.it_academy.jd2.core.dto.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private static UserRepository instance;
    private UserRepository(){}

    public static UserRepository getInstance(){
        if(instance == null){
            instance = new UserRepository();
        }
        return instance;
    }

    private static List<User> userList = new ArrayList<>();
    private User admin = new User("admin","admin","admin","admin","00.00.0000");
    {userList.add(admin);}

    public void addUserToRepository(User user) {
        userList.add(user);
    }

    public User getUserFromRepository(String login, String password) {
        User user = null;
        for (User u : userList) {
            if (login.equals(u.getLogin()) && password.equals(u.getPassword())) {
                user = u;
            }
        }
        return user;
    }

    public User getUserFromRepository(String login) {
        User user = null;
        for (User u : userList) {
            if (login.equals(u.getLogin())) {
                user = u;
            }
        }
        return user;
    }
}
