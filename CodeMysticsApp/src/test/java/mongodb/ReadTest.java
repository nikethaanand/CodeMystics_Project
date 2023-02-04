package mongodb;

import codemystics.HouseholdInformation;
import codemystics.TransportationInfo;
import codemystics.User;
import junit.framework.TestCase;

import java.util.List;

public class ReadTest extends TestCase {

    public void testGetByUserId() throws Exception {
        Read read = new Read();
        User user = read.getUserByUserId("testId");
        System.out.println(user.getFirstName());
    }

    public void testGetHouseByUserId() throws Exception {
        Read read = new Read();
        List<HouseholdInformation> list = read.getHouseHoldByUserId(123L);
        for (HouseholdInformation item:list){
            System.out.println(item.getElectricityUsage());
        }
    }

    public void testGetTransportByUserId() throws Exception {
        Read read = new Read();
        List<TransportationInfo> list = read.getTransportByUserId(123L);
        for (TransportationInfo item:list){
            System.out.println(item.getMilesPerMonth());
        }
    }
}