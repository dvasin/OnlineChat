package com.denis.command;

import com.denis.bean.Message;
import com.denis.bean.User;
import com.denis.dao.DAOFactory;
import com.denis.dao.MessageDAO;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by denis on 01.05.16.
 */
public class CommandSendMessage implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String textMessage = request.getParameter("message");
        User user = (User)request.getSession().getAttribute("user");
        MessageDAO messageDao = DAOFactory.getInstance().getMessageDAO();
        Message message = new Message(user, textMessage);
        messageDao.addMessage(message);
        String page = "/jsp/chat.jsp";
        return page;
    }
}
