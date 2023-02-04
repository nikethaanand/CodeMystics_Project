package codemystics;

import java.util.Date;

public class TransportationInfo {
    private long userId;
    private long milesPerMonth;
    private TransportationMode modeOfTransportation;
    private int averageMPG;
    private Date billDate;

    public TransportationInfo(long userId, long milesPerMonth, TransportationMode modeOfTransportation, int averageMPG, Date billDate) {
        this.userId = userId;
        this.milesPerMonth = milesPerMonth;
        this.modeOfTransportation = modeOfTransportation;
        this.averageMPG = averageMPG;
        this.billDate = billDate;
    }

    public long getUserId() {
        return userId;
    }

    public long getMilesPerMonth() {
        return milesPerMonth;
    }

    public TransportationMode getModeOfTransportation() {
        return modeOfTransportation;
    }

    public int getAverageMPG() {
        return averageMPG;
    }

    public Date getBillDate() {
        return billDate;
    }
}
