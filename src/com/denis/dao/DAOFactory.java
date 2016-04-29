package com.denis.dao;

import com.denis.dao.mysql.MySQLDAOFactory;

/**
 * Created by denis on 04.03.2016.
 */
public abstract class DAOFactory {

    private static DAOFactory factory;

    public static DAOFactory getInstance() {
        if(factory == null) {
            factory = new MySQLDAOFactory();
            return factory;
        } else return factory;
    }

    public abstract MessageDAO getMessageDAO();
    public abstract UserDAO getUserDAO();
}
