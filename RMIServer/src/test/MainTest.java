package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import rmi.*;
import rmi.ReadOnly.*;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainTest{

    @Test
    public void TestCreateDriverAccount() throws RemoteException {
        Account acc = new Account();
        Account new_acc = new Account();
        Driver new_dri = new Driver();
        DB db = new DB();

        //Driver Data
        String username = "omar";
        String password = "1234";
        String email = "omar1234";
        String mobile = "123456";
        AccType type = AccType.DRIVER;

        String driverLicense = "123ABC";
        AvailableTimes d1 = new AvailableTimes("Thursday");
        AvailableTimes d2 = new AvailableTimes("Friday");
        ArrayList<AvailableTimes> workingDays = new ArrayList<>();
        workingDays.add(d1);
        workingDays.add(d2);

        String carModel = "BYD";String plateNum = "NUM123"; String carColor = "BLACK";
        CurrentArea currentArea = CurrentArea.ZAMALEK;

        acc.createDriverAccount(username, password, email, mobile, type,
                driverLicense, workingDays, carModel, plateNum, carColor, (float) 0.0, currentArea);

        new_acc = db.retrieveAccount(email);

        assertEquals("omar",new_acc.getUsername());
        assertEquals("1234",new_acc.getPassword());
        assertEquals("omar1234",new_acc.getEmail());
        assertEquals("123456",new_acc.getMobile());

        new_dri= db.retrieveDriverByMail(email);

        assertEquals("123ABC",new_dri.getDriverLicense());
    }

    @Test
    public void TestRequestRide() throws RemoteException {
        ClientReadOnly client = (ClientReadOnly) new Client();
        DB db = new DB();
        String email = "omar1234";
        client.requestRide(CurrentArea.MAADI,CurrentArea.NASRCITY,email);

        ArrayList<RequestRide> rq = new ArrayList<RequestRide>();
        rq = db.retrieveAllRequestedRides();

        assertEquals("",rq.get(rq.size()-1).getRide_id());
    }
}
