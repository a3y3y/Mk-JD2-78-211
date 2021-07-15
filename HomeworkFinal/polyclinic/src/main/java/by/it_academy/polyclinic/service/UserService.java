package by.it_academy.polyclinic.service;

import by.it_academy.polyclinic.model.user_Info.User;
import by.it_academy.polyclinic.service.api.IUserService;
import by.it_academy.polyclinic.storage.IUserRepository;
import by.it_academy.polyclinic.util.UserRole;

import java.util.List;

public class UserService implements IUserService {

    IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User getUserByEmail(String eMail) {
        return userRepository.findAllByeMail(eMail).get(0);
    }

    public boolean checkPasswordAndLogin(String eMail, String password){
       List<User> users = userRepository.findAllByeMail(eMail);
       if(users.isEmpty()){
           return false;
       }
       if(users.get(0).getPassword().equals(password)){
           return true;
       }
       return false;
    }

    public User registerUser(String eMail, String password){
        User user = new User();
        user.setRole(UserRole.PATIENT);
        user.seteMail(eMail);
        user.setPassword(password);
        validationForSignUp(user);
        userRepository.save(user);
        return user;
    }
    private void validationForSignUp(User user) {
        String errorMessage = "";
        if (this.nullOrEmpty(user.geteMail())) {
            errorMessage += "E-mail обязателен для заполнения";
        }
        if (this.nullOrEmpty(user.getPassword())) {
            if (!errorMessage.isEmpty()) {
                errorMessage += "; ";
            }
            errorMessage += "Пароль обязателен для заполнения";
        }

        if (!errorMessage.isEmpty()) {
            throw new IllegalArgumentException(errorMessage);
        }
        if (!userRepository.findAllByeMail(user.geteMail()).isEmpty()) {
            throw new IllegalArgumentException("Этот почтовый адрес уже существует");
        }
    }
    private boolean nullOrEmpty(String val) {
        return val == null || val.isEmpty();
    }
}
