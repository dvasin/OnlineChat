package com.denis.command;

import com.denis.bean.Status;
import com.denis.bean.User;
import com.denis.dao.DAOFactory;
import com.denis.dao.UserDAO;
import com.denis.dao.mysql.MySQLUserDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by User on 29.04.2016.
 */
public class CommandLogin implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        String nick = request.getParameter("nick");
        UserDAO userDao = DAOFactory.getInstance().getUserDAO();
        User user = new User(nick);
        userDao.login(user);

        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        String page = "/jsp/chat.jsp";
        return page;
    }

}
