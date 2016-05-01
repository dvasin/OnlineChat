package com.denis.command;

import com.denis.bean.Message;
import com.denis.bean.User;
import com.denis.dao.DAOFactory;
import com.denis.dao.MessageDAO;
import com.denis.dao.UserDAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by denis on 01.05.16.
 */
public class CommandGetLoggedUsers implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        UserDAO userDao = DAOFactory.getInstance().getUserDAO();

        List<User> loggedInUsers= userDao.getLoggedinUsers();
        request.getServletContext().setAttribute("loggedinusers", loggedInUsers);

        String page = "/jsp/chat.jsp";
        return page;
    }
}
