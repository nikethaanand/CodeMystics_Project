package mongodb;

import codemystics.HouseholdInformation;
import codemystics.TransportationInfo;
import codemystics.User;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.ArrayList;
import java.util.List;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

/**
 * Connection Class handling connection to MongoDB
 */
public class Connection {
    public static final String connectionString = "mongodb+srv://Admin:AdminHusky2023@clustermystic.zejsuzj.mongodb.net/?retryWrites=true&w=majority";

    /**
     * Create new Connection String
     */
    public static final ConnectionString connectString = new ConnectionString(connectionString);

    public static final CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
    public static final CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
    public static final MongoClientSettings clientSettings = MongoClientSettings.builder()
            .applyConnectionString(connectString)
            .codecRegistry(codecRegistry)
            .build();
    public static final MongoClient mongoClient = MongoClients.create(clientSettings);
    /**
     * get the database related for this project
     */
    public static final MongoDatabase userDB = mongoClient.getDatabase("User");

    public static final MongoCollection<User> userCollection = Connection.userDB.getCollection("users details", User.class);
    public static final MongoCollection<HouseholdInformation> houseCollection = Connection.userDB.getCollection("house details", HouseholdInformation.class);
    public static final MongoCollection<TransportationInfo> transportCollection = Connection.userDB.getCollection("transport details", TransportationInfo.class);
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

}
