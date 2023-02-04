package com.mongodb.quickstart;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Connection Class handling connection to MongoDB
 */
public class Connection {
    public static final String connectionString = "mongodb+srv://Admin:AdminHusky2023@clustermystic.zejsuzj.mongodb.net/?retryWrites=true&w=majority";
    /**
     * mongoClient open a connection to the hosted MongoDB with the connectionString
     */
    public static final MongoClient mongoClient = MongoClients.create(connectionString);
    /**
     * get the database related for this project
     */
    public static final MongoDatabase userDB = mongoClient.getDatabase("User");
    public static void main(String[] args) {

        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            List<Document> databases = mongoClient.listDatabases().into(new ArrayList<>());
            databases.forEach(db -> System.out.println(db.toJson()));
        }
    }
}
