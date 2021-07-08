package by.it_academy.jd2.hw.example.messenger.storage.api;

import by.it_academy.jd2.hw.example.messenger.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

/**
 * Gets info from user database
 * @author Maksim Perekladov
 * @version 2.0
 */

public interface IUserRepository extends JpaRepository<User, String> {
}
