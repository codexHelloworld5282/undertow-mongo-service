package com.example.app.routes;

import io.undertow.server.HttpHandler;
import com.example.app.handlers.UserHandler;

public class UserRoutes {
    public static HttpHandler getUsers() {
        return UserHandler::handleGetUsers;
    }

    public static HttpHandler createUser() {
        return UserHandler::handleCreateUser;
    }
}
