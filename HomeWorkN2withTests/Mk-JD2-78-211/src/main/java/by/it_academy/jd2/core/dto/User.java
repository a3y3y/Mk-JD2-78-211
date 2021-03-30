package by.it_academy.jd2.core.dto;

public class User {
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String birthDate;

    public User(String login, String password, String firstName, String lastName, String birthDate) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public String getLogin() {
        return login;
    }


    public String getPassword() {
        return password;
    }

}
