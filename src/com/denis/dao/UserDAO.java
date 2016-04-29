package com.denis.dao;

import com.denis.bean.*;

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

}
