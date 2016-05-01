package com.denis.command;

import com.denis.bean.User;
import com.denis.dao.DAOFactory;
import com.denis.dao.UserDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by denis on 29.04.16.
 */
public class CommandLogout implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");

        UserDAO userDao = DAOFactory.getInstance().getUserDAO();
        userDao.logout(user);

        request.getSession().invalidate();
        String page = "/index.jsp";
        return page;
    }
}
