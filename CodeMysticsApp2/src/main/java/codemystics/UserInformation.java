package codemystics;

import mongodb.Create;

import java.util.Date;

public class UserInformation {

    public void saveUser(User user) throws Exception {
        Create create = new Create();
        create.insertRecord(user,"user");
    }

    public void saveUserHouseholdBill(User user) throws Exception {
        HouseholdInformation householdInformation = new HouseholdInformation(user.getUserId(), 500, 2,
                new Date());
        Create create = new Create();
        create.insertRecord( householdInformation,"house");
        String result = "User saved : " + user;
    }
}
