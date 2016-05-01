package com.denis.bean;

/**
 * Created by denis on 06.03.2016.
 */
public class User {
    private String nick;
    private Status status;
    private Role role;

    public User() {
        super();
    }

    public User(String nick, Status status, Role role) {
        this.nick = nick;
        this.status = status;
        this.role = role;
    }

    public User(String nick) {
        this.nick = nick;
        this.status = Status.LOGIN;
        this.role = Role.USER;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getNick() {

        return nick;
    }

    public Status getStatus() {
        return status;
    }

    public Role getRole() {
        return role;
    }
}
