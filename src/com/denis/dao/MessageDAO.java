package com.denis.dao;

import com.denis.bean.Message;

import java.util.List;

/**
 * Created by denis on 06.03.2016.
 */
public interface MessageDAO {

    void addMessage(Message message);
    List<Message> getLastMessage(int amount);
}
