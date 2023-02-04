package com.mongodb.quickstart;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.List;

import static java.util.Arrays.asList;

public class Create {

    public static void main(String[] args) {
        try (MongoClient mongoClient = MongoClients.create(Connection.connectionString)) {
            MongoDatabase userDB = mongoClient.getDatabase("User");
            MongoCollection<Document> userCollection = userDB.getCollection("users details");
            insertOneDocument(userCollection);
        }
    }

    private static void insertOneDocument(MongoCollection<Document> gradesCollection) {
        gradesCollection.insertOne(generateNewUser(10000d, "test"));
        System.out.println("One user inserted.");
    }

    private static Document generateNewUser(double userId, String password) {
        return new Document("_id", new ObjectId()).append("user_id", userId)
                .append("password", password);
    }
}
