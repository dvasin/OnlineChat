package com.denis.bean;

import java.util.Date;

/**
 * Created by denis on 06.03.2016.
 */
public class Message {

    private User user;
    private String text;
    private Date timestamp;

    public Message() {
        super();
    }

    public Message(User user, String text) {
        this.user = user;
        this.text = text;
    }

    public Message(User user, Date timestamp, String text) {
        this.user = user;
        this.timestamp = timestamp;
        this.text = text;
    }

    @Override
    public String toString() {
        return "Message{" +
                "user=" + user +
                ", text='" + text + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public User getUser() {
        return user;
    }

    public String getText() {
        return text;
    }

    public Date getTimestamp() {

        return timestamp;
    }
}
