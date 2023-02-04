package com.mongodb.quickstart;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
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

    public static final MongoCollection<Document> userCollection = Connection.userDB.getCollection("users details");
    public static final MongoCollection<Document> houseCollection = Connection.userDB.getCollection("house details");
    public static final MongoCollection<Document> transportCollection = Connection.userDB.getCollection("transport details");
    public static final String USERTYPE = "user";
    public static final String HOUSETYPE = "house";
    public  static final String TRANSPORTTYPE = "transport";

    /**
     * Set the collection (table) to the required type for CRUD operation
     * @param type type of collection , selection from "user", "house", "transport"
     * @return MongoCollection<Document> object
     * @throws Exception when invalid type is encountered
     */
    public static MongoCollection<Document> setCollection (String type) throws Exception {
        MongoCollection collection;
        if (USERTYPE.equals(type)){
            collection = userCollection;
        }else if (HOUSETYPE.equals(type)){
            collection = houseCollection;
        }else if (TRANSPORTTYPE.equals(type)){
            collection = transportCollection;
        }else{
            throw new Exception("Invalid Type");
        }
        return collection;
    }
    public static void main(String[] args) {

        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            List<Document> databases = mongoClient.listDatabases().into(new ArrayList<>());
            databases.forEach(db -> System.out.println(db.toJson()));
        }
    }
}
