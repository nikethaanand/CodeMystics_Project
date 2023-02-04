package com.mongodb.quickstart;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class Connection {
    public static final String connectionString = "mongodb+srv://Admin:AdminHusky2023@clustermystic.zejsuzj.mongodb.net/?retryWrites=true&w=majority";
    public static void main(String[] args) {

        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            List<Document> databases = mongoClient.listDatabases().into(new ArrayList<>());
            databases.forEach(db -> System.out.println(db.toJson()));
        }
    }
}
