package com.denis.command;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by denis on 03.05.16.
 */
public class CommandFactory {

    public Command defineCommand(HttpServletRequest request) {
        Command command = new EmptyCommand();

        String commandFromParameter = request.getParameter("command");
        if (commandFromParameter == null || commandFromParameter.isEmpty()) {
            return command;
        }
        command = EnumCommand.valueOf(commandFromParameter.toUpperCase()).getCommand();
        return command;

    }

}
