package mongodb;

import codemystics.HouseholdInformation;
import codemystics.TransportationInfo;
import codemystics.User;
import com.mongodb.client.MongoCollection;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

/**
 * Read Class to perform retrieve operation
 */
public class Read {
    /**
     * Retrieve the User by UserId
     * @param userId
     * @return
     * @throws Exception
     */
    public User getUserByUserId(String userId) throws Exception {
        MongoCollection collection = Connection.setCollection(Connection.USERTYPE);
        User user = (User) collection.find(eq("userId", userId)).first();
        return user;
    }

    /**
     * Retrieve a list of Household info for particular user
     * @param userId
     * @return
     * @throws Exception
     */
    public List<HouseholdInformation> getHouseHoldByUserId(Long userId) throws Exception {
        MongoCollection collection = Connection.setCollection(Connection.HOUSETYPE);
        List<HouseholdInformation> list = (List<HouseholdInformation>) collection.find(eq("userId", userId)).into(new ArrayList<>());
        return list;
    }

    /**
     * Retrieve a list of Transport info for particular user
     * @param userId
     * @return
     * @throws Exception
     */
    public List<TransportationInfo> getTransportByUserId(Long userId) throws Exception {
        MongoCollection collection = Connection.setCollection(Connection.TRANSPORTTYPE);
        List<TransportationInfo> list = (List<TransportationInfo>) collection.find(eq("userId", userId)).into(new ArrayList<>());
        return list;
    }

}