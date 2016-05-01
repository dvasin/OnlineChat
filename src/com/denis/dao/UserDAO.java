package com.denis.dao;

import com.denis.bean.*;

import java.util.List;

/**
 * Created by denis on 06.03.2016.
 */
public interface UserDAO {
    boolean login(User user);
    boolean logout(User user);
    boolean kick(User user);
    Status getStatus(User user);
    Role getRole(User user);
    boolean unkick(User user);
    List<User> getLoggedinUsers();

}
