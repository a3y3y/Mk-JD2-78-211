package by.it_academy.jd2.hw.example.messenger.model;

import org.hibernate.annotations.Proxy;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
@Entity(name = "Person")
@Table(name = "users", schema = "mess")
@Proxy(lazy=false)

/**
 * Data transfer object for user
 * @author Maksim Perekladov
 * @version 2.0
 */

public class User implements Serializable {
    @Id
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "fio")
    private String fio;
    @Column(name = "birth_date")
    private Date birthday;
    @Column(name = "registration_date")
    private Date registration;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getRegistration() {
        return registration;
    }

    public void setRegistration(Date registration) {
        this.registration = registration;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", fio='" + fio + '\'' +
                ", birthday=" + birthday +
                ", registration=" + registration +
                '}';
    }
}
