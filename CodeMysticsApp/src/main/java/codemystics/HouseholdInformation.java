package codemystics;

import java.util.Date;

public class HouseholdInformation {
    private long userId;
    private long electricityUsage;
    private int householdNumbers;
    private Date billDate;

    public HouseholdInformation(long userId, long electricityUsage, int householdNumbers, Date billDate) {
        this.userId = userId;
        this.electricityUsage = electricityUsage;
        this.householdNumbers = householdNumbers;
        this.billDate = billDate;
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
