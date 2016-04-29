package com.denis.dao.mysql;

import com.denis.dao.MessageDAO;
import com.denis.dao.UserDAO;

/**
 * Created by denis on 06.03.2016.
 */
public class MySQLDAOFactory extends com.denis.dao.DAOFactory {

    @Override
    public MessageDAO getMessageDAO() {
        return new MySQLMessageDAO();
    }

    @Override
    public UserDAO getUserDAO() {
        return new MySQLUserDAO();
    }

}
