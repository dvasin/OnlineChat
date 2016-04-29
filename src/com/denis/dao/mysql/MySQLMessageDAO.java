package com.denis.dao.mysql;

import com.denis.bean.Message;
import com.denis.bean.User;
import com.denis.dao.MessageDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by denis on 06.03.2016.
 */
public class MySQLMessageDAO implements MessageDAO {

    private ConnectionPool connectionPool = ConnectionPool.getInstance();

    private static final String INS_MESSAGE = "INSERT INTO Message(nick, text) VALUES(?,?)";
    private static final String GET_LAST_MES = "SELECT * FROM Message WHERE id > (SELECT MAX(id) - ? FROM Message) ORDER BY id DESC";

    @Override
    public void addMessage(Message message) {
        Connection c = null;
        PreparedStatement st = null;
        try {
            c = connectionPool.getConnection();
            st = c.prepareStatement(INS_MESSAGE);
            st.setString(1, message.getUser().getNick());
            st.setString(2, message.getText());
            st.setString(3, new Date().toString());
            st.executeUpdate();
            connectionPool.freeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Message> getLastMessage(int amount) {
        Connection c = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        List<Message> lastMessages = new ArrayList<>();
        try {
            c = connectionPool.getConnection();
            st = c.prepareStatement(GET_LAST_MES);
            st.setInt(1, amount);
            rs = st.executeQuery();
            while(rs.next()) {
                String nick = rs.getString("nick");
                Date timestamp = rs.getDate("date");
                String text = rs.getString("text");
                lastMessages.add(new Message(new User(nick), timestamp, text));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lastMessages;
    }
}
