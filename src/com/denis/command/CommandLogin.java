package com.denis.command;

import com.denis.bean.Status;
import com.denis.bean.User;
import com.denis.dao.DAOFactory;
import com.denis.dao.UserDAO;
import com.denis.dao.mysql.MySQLUserDAO;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by User on 29.04.2016.
 */
public class CommandLogin implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        String nick = request.getParameter("nick");
        UserDAO user = DAOFactory.getInstance().getUserDAO();
        user.login(new User(nick));
        String page = "/jsp/chat.jsp";
        return page;
    }

}
