package com.denis.dao;

import com.denis.bean.Message;
import com.denis.bean.Role;
import com.denis.bean.Status;
import com.denis.bean.User;
import com.denis.dao.mysql.MySQLDAOFactory;
import java.util.Date;

public class Test2 {

    public static void main(String[] args) {
        /*MySQLDAOFactory factory = (MySQLDAOFactory)DAOFactory.getInstance();
        System.out.println(factory.getUserDAO().getRole(new User("Denis22")));*/

        DAOFactory daoFactory = DAOFactory.getInstance();
        daoFactory.getUserDAO().login(new User("qwe33"));

        //MySQLDAOFactory factory = (MySQLDAOFactory)DAOFactory.getInstance();
        //factory.getMessageDAO().addMessage(new Message(new User("me", Status.LOGIN, Role.USER),new Date(), "Hello"));
    }
}
