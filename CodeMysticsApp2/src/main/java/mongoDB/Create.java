package mongoDB;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.lang.reflect.Field;

/**
 * Create class to perform insert operation
 */
public class Create {

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
        MongoCollection collection = Connection.setCollection(type);
        collection.insertOne(this.generateDoc(data));
        System.out.println("One data inserted.");
    }
}
