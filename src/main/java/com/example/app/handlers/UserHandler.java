package com.example.app.handlers;

import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;

import com.example.app.db.MongoConnection;
import com.example.app.utils.JsonUtil;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class UserHandler {

    private static MongoCollection<Document> getCollection() {
        return MongoConnection.getDatabase().getCollection("users");
    }

    public static void handleGetUsers(HttpServerExchange exchange) {
        List<Document> users = new ArrayList<>();
        getCollection().find().into(users);

        exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "application/json");
        exchange.getResponseSender().send(JsonUtil.toJson(users));
    }

    public static void handleCreateUser(HttpServerExchange exchange) {
        exchange.getRequestReceiver().receiveFullString((ex, body) -> {
            Document user = new Document("name", body);
            getCollection().insertOne(user);

            ex.getResponseHeaders().put(Headers.CONTENT_TYPE, "application/json");
            ex.getResponseSender().send(JsonUtil.toJson(user));
        });
    }
}
