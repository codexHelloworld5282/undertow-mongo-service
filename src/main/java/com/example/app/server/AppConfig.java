package com.example.app.server;

import io.undertow.Handlers;
import io.undertow.server.HttpHandler;
import com.example.app.routes.UserRoutes;

public class AppConfig {
    public static HttpHandler getRoutes() {
        return Handlers.routing()
                .add("GET", "/api/users", UserRoutes.getUsers())
                .add("POST", "/api/users", UserRoutes.createUser());
    }
}
