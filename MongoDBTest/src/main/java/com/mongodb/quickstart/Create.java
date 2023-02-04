package com.mongodb.quickstart;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.lang.reflect.Field;

/**
 * Create class to perform insert operation
 */
public class Create {
    private static final MongoCollection<Document> userCollection = Connection.userDB.getCollection("users details");
    private static final MongoCollection<Document> houseCollection = Connection.userDB.getCollection("house details");
    private static final MongoCollection<Document> transportCollection = Connection.userDB.getCollection("transport details");
    private static final String USERTYPE = "user";
    private static final String HOUSETYPE = "house";
    private static final String TRANSPORTTYPE = "transport";

    /**
     * Create the Document to be inserted into the MongoDB
     * @param data DataModel object to be inserted
     * @return Document to be inserted into the MongoDB
     * @throws IllegalAccessException when trying to access the field of the Data object
     */
    public Document generateDoc(DataModel data) throws IllegalAccessException {
        Document document = new Document("_id", new ObjectId());
        for (Field field : data.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            document.append(field.getName(), field.get(data));
        }
        return document;
    }


    /**
     * Insert the data as a new record to MongoDB
     * @param data Date object containing the new record
     * @param type type of insertion , selection from "user", "house", "transport"
     */
    public void insertRecord(DataModel data, String type) throws Exception {
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
        collection.insertOne(this.generateDoc(data));
        System.out.println("One data inserted.");
    }
}
