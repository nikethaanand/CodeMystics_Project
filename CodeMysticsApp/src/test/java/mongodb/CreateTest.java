package mongodb;

import codemystics.HouseholdInformation;
import codemystics.TransportationInfo;
import codemystics.TransportationMode;
import codemystics.User;
import junit.framework.TestCase;

import java.sql.Date;

public class CreateTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void testInsertRecord() throws Exception {
        User dataUser = new User("testId", "first name", "last name", "test@yahoo.com");
        Create create = new Create();
        create.insertRecord(dataUser,"user");
    }

    public void testInsertRecordHousehold() throws Exception {
        HouseholdInformation house = new HouseholdInformation("123", 200,200, new Date(2023,02, 04));
        Create create = new Create();
        create.insertRecord(house,Connection.HOUSETYPE);
    }

    public void testInsertRecordTransport() throws Exception {
        TransportationInfo transport = new TransportationInfo("123", 200,"car", 200, new Date(2023,02, 04));
        Create create = new Create();
        create.insertRecord(transport,Connection.TRANSPORTTYPE);
    }
}