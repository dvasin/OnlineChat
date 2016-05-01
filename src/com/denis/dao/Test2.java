package com.denis.dao;

import com.denis.bean.Message;
import com.denis.bean.Role;
import com.denis.bean.Status;
import com.denis.bean.User;
import com.denis.dao.mysql.MySQLDAOFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Test2 {

    public static void main(String[] args) {
        /*MySQLDAOFactory factory = (MySQLDAOFactory)DAOFactory.getInstance();
        System.out.println(factory.getUserDAO().getRole(new User("Denis22")));*/
       /* DAOFactory daoFactory = DAOFactory.getInstance();
        daoFactory.getUserDAO().logout(new User("dfgf"));*/
/*        UserDAO user = DAOFactory.getInstance().getUserDAO();
        System.out.println(user);*/
        //MySQLDAOFactory factory = (MySQLDAOFactory)DAOFactory.getInstance();
        //factory.getMessageDAO().addMessage(new Message(new User("me", Status.LOGIN, Role.USER),new Date(), "Hello"));
        ArrayList<String> arr = new ArrayList<>();
        arr.add("a");
        arr.add("a2");
        arr.add("b");
        arr.add("c");
        Collections.reverse(arr);
        System.out.println(arr);
    }
}
