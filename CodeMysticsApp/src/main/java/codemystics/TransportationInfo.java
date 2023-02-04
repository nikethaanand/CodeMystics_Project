package codemystics;

import mongodb.DataModel;

import java.util.Date;

public class TransportationInfo implements DataModel {
    private String userId;
    private long milesPerMonth;
    // private TransportationMode modeOfTransportation;
    private String modeOfTransportation;
    private int averageMPG;
    private Date billDate;

    /**
     * Constructor
     * @param userId
     * @param milesPerMonth
     * @param modeOfTransportation
     * @param averageMPG
     * @param billDate
     */
    public TransportationInfo(String userId, long milesPerMonth, String modeOfTransportation, int averageMPG, Date billDate) {
        this.userId = userId;
        this.milesPerMonth = milesPerMonth;
        this.modeOfTransportation = modeOfTransportation.toString();
        this.averageMPG = averageMPG;
        this.billDate = billDate;
    }

    /**
     * Public empty constructor for POJO mapping
     */
    public TransportationInfo(){

    }
    public String getUserId() {
        return userId;
    }

    public long getMilesPerMonth() {
        return milesPerMonth;
    }

/*    public TransportationMode getModeOfTransportation() {
        return new TransportationMode();
    }*/

    public int getAverageMPG() {
        return averageMPG;
    }

    public Date getBillDate() {
        return billDate;
    }
}
