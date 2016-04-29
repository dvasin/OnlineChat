package com.denis.command;

import com.denis.bean.User;
import com.denis.dao.DAOFactory;
import com.denis.dao.UserDAO;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by denis on 29.04.16.
 */
public class CommandLogout implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        String nick = request.getParameter("nick");
        UserDAO user = DAOFactory.getInstance().getUserDAO();
        user.logout(new User(nick));
        request.getSession().invalidate();
        String page = "/index.jsp";
        return page;
    }
}
