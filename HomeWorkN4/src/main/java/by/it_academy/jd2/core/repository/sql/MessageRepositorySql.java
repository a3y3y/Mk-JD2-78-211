package by.it_academy.jd2.core.repository.sql;

import by.it_academy.jd2.core.dto.Message;
import by.it_academy.jd2.core.repository.MessageDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.it_academy.jd2.core.util.AbstractConnection.getConnection;

public class MessageRepositorySql implements MessageDao {

    private static final String ADD_MESSAGE = "INSERT INTO messages (sender, recipient, message_text, send_time)\n" +
            "VALUES (?, ?, ?, ?)";
    private static final String GET_MESSAGE = "SELECT * FROM messages WHERE recipient=?";

    @Override
    public void addMessageToRepository(Message message) {
        try (PreparedStatement stmt = getConnection().prepareStatement(ADD_MESSAGE)) {
            stmt.setString(1, message.getSender());
            stmt.setString(2, message.getRecipient());
            stmt.setString(3, message.getMessageText());
            stmt.setString(4, message.getSendTime());
            stmt.executeQuery();
        } catch (SQLException e) {
            e.getMessage();
        }

    }

    @Override
    public List<Message> getMessagesFromRepository(String recipient) {
        List<Message> list = new ArrayList<>();
        try (PreparedStatement stmt = getConnection().prepareStatement(GET_MESSAGE)) {
            stmt.setString(1, recipient);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Message message = new Message();
                message.setSender(rs.getString("sender"));
                message.setRecipient(rs.getString("recipient"));
                message.setMessageText(rs.getString("message_text"));
                message.setSendTime(rs.getString("send_time"));
                list.add(message);
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return list;
    }
}
