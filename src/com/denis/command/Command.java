package com.denis.command;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by denis on 29.04.16.
 */
public interface Command {

    String execute(HttpServletRequest request);
}
