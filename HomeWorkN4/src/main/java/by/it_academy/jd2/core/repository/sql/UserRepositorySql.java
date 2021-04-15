package by.it_academy.jd2.core.repository.sql;

import by.it_academy.jd2.core.dto.User;
import by.it_academy.jd2.core.repository.UserDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static by.it_academy.jd2.core.util.AbstractConnection.getConnection;

public class UserRepositorySql implements UserDao {

    private static final String GET_USER_BY_LOGIN = "SELECT * FROM users WHERE login=?";
    private static final String GET_USER_BY_LOGIN_PASSWORD = "SELECT * FROM users WHERE login=? AND password=?";
    private static final String ADD_USER = "INSERT INTO users (login, password, first_name, last_name" +
            ", birthdate) VALUES (?, ?, ?, ?, ?)";


    @Override
    public void addUserToRepository(User user) {
        try (PreparedStatement stmt = getConnection().prepareStatement(ADD_USER)) {
            stmt.setString(1, user.getLogin());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getFirstName());
            stmt.setString(4, user.getLastName());
            stmt.setString(5, user.getBirthDate());
            stmt.executeQuery();
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    @Override
    public User getUserFromRepository(String login) {
        User user = null;
        try (PreparedStatement stmt = getConnection().prepareStatement(GET_USER_BY_LOGIN)) {
            stmt.setString(1,login);
            try(ResultSet rs = stmt.executeQuery()) {
                while(rs.next()) {
                    user = new User();
                    user.setLogin(rs.getString("login"));
                    user.setPassword(rs.getString("password"));
                    user.setFirstName(rs.getString("first_name"));
                    user.setLastName(rs.getString("last_name"));
                    user.setBirthDate(rs.getString("birthdate"));
                }
            }
        } catch (SQLException e) {
            e.getMessage();
        }return user;
    }

    @Override
    public User getUserFromRepository(String login, String password) {
        User user = null;
        try (PreparedStatement stmt = getConnection().prepareStatement(GET_USER_BY_LOGIN_PASSWORD)) {
            stmt.setString(1, login);
            stmt.setString(2, password);
            try(ResultSet rs = stmt.executeQuery()) {
                while(rs.next()) {
                    user= new User();
                    user.setLogin(rs.getString("login"));
                    user.setPassword(rs.getString("password"));
                    user.setFirstName(rs.getString("first_name"));
                    user.setLastName(rs.getString("last_name"));
                    user.setBirthDate(rs.getString("birthdate"));
                }
            }
        } catch (SQLException e) {
            e.getMessage();
        }return user;
    }
}
