package codemystics;

import mongodb.DataModel;

import java.util.Date;

public class HouseholdInformation implements DataModel {
    private long userId;
    private long electricityUsage;
    private int householdNumbers;
    private Date billDate;

    /**
     * Constructor
     * @param userId
     * @param electricityUsage
     * @param householdNumbers
     * @param billDate
     */
    public HouseholdInformation(long userId, long electricityUsage, int householdNumbers, Date billDate) {
        this.userId = userId;
        this.electricityUsage = electricityUsage;
        this.householdNumbers = householdNumbers;
        this.billDate = billDate;
    }

    /**
     * Public empty constructor for POJO mapping to MongoDB
     */
    public HouseholdInformation(){

    }
    public long getUserId() {
        return userId;
    }

    public long getElectricityUsage() {
        return electricityUsage;
    }

    public int getHouseholdNumbers() {
        return householdNumbers;
    }

    public Date getBillDate() {
        return billDate;
    }
}
