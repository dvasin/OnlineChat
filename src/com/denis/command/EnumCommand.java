package com.denis.command;

/**
 * Created by denis on 03.05.16.
 */
public enum EnumCommand {

    LOGIN {
        {
            this.command = new CommandLogin();
        }
    },
    LOGOUT {
        {
            this.command = new CommandLogout();
        }
    },
    SENDMESSAGE {
        {
            this.command = new CommandSendMessage();
        }

    },
    GETLASTMESSAGES {
        {
            this.command = new CommandGetLastMessages();
        }
    },
    GETLOGGEDINUSERS {
        {
            this.command = new CommandGetLoggedInUsers();
        }
    };

    Command command;

    public Command getCommand() {
        return command;
    }

}
