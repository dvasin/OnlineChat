package com.denis.dao.mysql;

import com.denis.bean.Role;
import com.denis.bean.Status;
import com.denis.bean.User;
import com.denis.dao.UserDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Created by denis on 06.03.2016.
 */
public class MySQLUserDAO implements UserDAO {

    private ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static String EXIST_USER_SET_STATUS_LOGIN = "UPDATE User SET Status = 'login' WHERE NICK = ?";
    private static String EXIST_USER_SET_STATUS_LOGOUT = "UPDATE User SET Status = 'logout' WHERE NICK = ?";
    private static String EXIST_USER_SET_STATUS_KICK = "UPDATE User SET Status = 'kick' WHERE NICK = ?";
    private static String GET_ALL_USERS = "SELECT NICK FROM User";
    private static String EXIST_USER_GET_STATUS = "SELECT status from User where nick = ?";
    private static String EXIST_USER_GET_ROLE = "SELECT role from User where nick = ?";
    private static String CREATE_NEW_USER = "INSERT INTO User VALUES(?, ?, ?)";

    @Override
    public boolean login(User user) {
        Connection c = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            c = connectionPool.getConnection();
            st = c.prepareStatement(GET_ALL_USERS);
            rs = st.executeQuery();
            while (rs.next()) {
                if(user.getNick().equals(rs.getString("nick"))) {
                    st = c.prepareStatement(EXIST_USER_SET_STATUS_LOGIN);
                    st.setString(1, user.getNick());
                    st.executeUpdate();
                    return true;
                }
            }
            st = c.prepareStatement(CREATE_NEW_USER);
            st.setString(1, user.getNick());
            st.setString(2, user.getStatus().toString().toLowerCase());
            st.setString(3, user.getRole().toString().toLowerCase());
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            connectionPool.freeConnection(c);
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean logout(User user) {
        Connection c = connectionPool.getConnection();
        PreparedStatement st = null;
        try {
            st = c.prepareStatement(EXIST_USER_SET_STATUS_LOGOUT);
            st.setString(1, user.getNick());
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.freeConnection(c);
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;

    }

    @Override
    public boolean kick(User user) {
        Connection c = connectionPool.getConnection();
        PreparedStatement st = null;
        try {
            st = c.prepareStatement(EXIST_USER_SET_STATUS_KICK);
            st.setString(1, user.getNick());
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.freeConnection(c);
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Status getStatus(User user) {
        Connection c = connectionPool.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = c.prepareStatement(EXIST_USER_GET_STATUS);
            st.setString(1, user.getNick());
            rs = st.executeQuery();
            while (rs.next()) {
                String status = rs.getString("status");
                return Status.valueOf(status.toUpperCase());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.freeConnection(c);
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return Status.UNKNOWN;
    }

    @Override
    public Role getRole(User user) {
        Connection c = connectionPool.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = c.prepareStatement(EXIST_USER_GET_ROLE);
            st.setString(1, user.getNick());
            rs = st.executeQuery();
            while (rs.next()) {
                String role = rs.getString("role");
                return Role.valueOf(role.toUpperCase());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.freeConnection(c);
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return Role.USER;
    }

    @Override
    public boolean unkick(User user) {
        Connection c = connectionPool.getConnection();
        PreparedStatement st = null;
        try {
            st = c.prepareStatement(EXIST_USER_SET_STATUS_LOGOUT);
            st.setString(1, user.getNick());
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.freeConnection(c);
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
