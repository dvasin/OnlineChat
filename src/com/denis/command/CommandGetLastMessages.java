package com.denis.command;

import com.denis.bean.Message;
import com.denis.dao.DAOFactory;
import com.denis.dao.MessageDAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by denis on 01.05.16.
 */
public class CommandGetLastMessages implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String textMessage = request.getParameter("GETLASTMESSAGES");
        MessageDAO messageDao = DAOFactory.getInstance().getMessageDAO();

        List<Message> lastMessages= messageDao.getLastMessage(50);
        request.getServletContext().setAttribute("lastmessages", lastMessages);

        String page = "/jsp/chat.jsp";
        return page;
    }
}
