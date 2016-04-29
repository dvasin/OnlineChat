package com.denis.dao.mysql;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by denis on 06.03.2016.
 */
public class ConnectionPool {

    private static ConnectionPool connectionPool;
    private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    private static final String user = "denis";
    private static final String password = "password";
    private static final String url = "jdbc:mysql://109.94.176.197:3306/dvasin";

    static {
        Driver driver = null;
        try {
            driver = (Driver) Class.forName(
                    DRIVER_NAME).newInstance();
            DriverManager.registerDriver(driver);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ConnectionPool getInstance() {
        if(connectionPool == null) {
            return new ConnectionPool();
        } else return connectionPool;
    }

    public Connection getConnection() {
        Connection c = null;
        try {
            c = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    public void freeConnection(Connection c)  {
        try {
            if(c != null) {
                c.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




}
