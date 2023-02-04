package mongodb;

import codemystics.User;
import junit.framework.TestCase;

public class CreateTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void testInsertRecord() throws Exception {
        User dataUser = new User("testId", "first name", "last name", "test@yahoo.com");
        Create create = new Create();
        create.insertRecord(dataUser,"user");
    }
}