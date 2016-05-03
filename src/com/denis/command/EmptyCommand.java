package com.denis.command;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by denis on 03.05.16.
 */
public class EmptyCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return new String("/index.jsp");
    }
}
