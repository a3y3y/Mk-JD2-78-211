package by.it_academy.jd2.hw.example.messenger.model;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
/**
 * Data transfer object for message
 * @author Maksim Perekladov
 * @version 2.0
 */
@Entity(name = "Message")
@Table(name = "messages", schema = "mess")
@Proxy(lazy=false)
public class Message implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "sender")
    private String sender;
    @Column(name = "send_date")
    private Date sendDate;
    @Column(name = "text")
    private String text;
    @Column(name = "recipient")
    private String recipient;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getFrom() {
        return sender;
    }

    public void setFrom(String from) {
        this.sender = from;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
