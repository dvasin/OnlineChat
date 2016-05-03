package com.denis.controller;

import com.denis.command.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by denis on 28.04.16.
 */
@WebServlet("/chat")
public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String page = null;
        CommandFactory factory = new CommandFactory();
        Command command = factory.defineCommand(request);
        page = command.execute(request);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);


        /*if(request.getParameter("command").equals("logout")) {
            String page = new CommandLogout().execute(request);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
            dispatcher.forward(request, response);
        } else if(request.getParameter("command").equals("login")) {
            String page = new CommandLogin().execute(request);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
            dispatcher.forward(request, response);
        } else if(request.getParameter("command").equals("sendMessageAndRefresh")) {
            new CommandSendMessage().execute(request);
            new CommandGetLoggedInUsers().execute(request);
            String page = new CommandGetLastMessages().execute(request);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
            dispatcher.forward(request, response);
        }*/
    }
}

