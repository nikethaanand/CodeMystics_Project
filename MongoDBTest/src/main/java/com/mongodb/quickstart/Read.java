package com.mongodb.quickstart;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

/**
 * Read Class to perform retrieve operation
 */
public class Read {
    public List<DataModel> getByUserId(String userId, String type) throws Exception {
        MongoCollection collection = Connection.setCollection(type);
        List<Document> list = (List<Document>) collection.find(eq("userId", userId)).into(new ArrayList<>());
        for(Document data: list){
            System.out.println(data.toJson());
        }
        return null;
    }
}
