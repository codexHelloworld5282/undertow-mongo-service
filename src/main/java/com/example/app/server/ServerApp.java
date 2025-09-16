package com.example.app.server;

import io.undertow.Undertow;
import io.undertow.server.HttpHandler;

public class ServerApp {
    public static void main(String[] args) {
        HttpHandler appHandler = AppConfig.getRoutes();

        Undertow server = Undertow.builder()
                .addHttpListener(8080, "0.0.0.0")
                .setHandler(appHandler)
                .build();

        server.start();
        System.out.println(" Undertow server running at http://localhost:8080");
    }
}
