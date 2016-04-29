package com.denis.dao;
import java.sql.*;

import com.denis.bean.Message;
import com.denis.bean.Role;
import com.denis.bean.Status;
import com.denis.bean.User;
import com.denis.dao.mysql.MySQLDAOFactory;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by denis on 06.03.2016.
 */
public class Test {

    private static final String url = "jdbc:mysql://109.94.176.197:3306/dvasin";
    private static final String user = "denis";
    private static final String password = "password";
    private static Connection con;
    private static PreparedStatement stmt;
    private static ResultSet rs;

    public static void main(String[] args) {
        //MySQLDAOFactory factory = (MySQLDAOFactory)DAOFactory.getInstance();
        //factory.getMessageDAO().addMessage(new Message(new User("me", Status.LOGIN, Role.USER), "Hello", new Date()));
        //String query = "GRANT ALL PRIVILEGES ON *.* TO 'denis'@'%'";
       // String query = "SHOW GRANTS FOR 'root'@'testserver'";
        //String query = "SELECT * FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA = 'dvasin' AND TABLE_NAME = 'Message';";
        String query =
                "select * from User";

        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);

            // getting Statement object to execute query
            stmt = con.prepareStatement(query);

            // executing SELECT query
            rs = stmt.executeQuery(query);
            //stmt.executeUpdate(query);
            while (rs.next()) {
                String count1 = rs.getString(1);
                String count2 = rs.getString(2);
                //Date count3 = rs.getTimestamp(3);
                //String count4 = rs.getString(4);
                System.out.println(count1 + " | " + count2 /*+ " | " + count3 + " | " + count4*/);
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
           // try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }
    }

    }


