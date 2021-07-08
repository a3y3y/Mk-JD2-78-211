package by.it_academy.jd2.hw.example.messenger.storage.api;

import by.it_academy.jd2.hw.example.messenger.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Gets info message database
 * @author Maksim Perekladov
 * @version 2.0
 */

public interface IChatRepository extends JpaRepository<Message, Long> {
    List<Message> findAllBySender(String sender);
}
