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
        ClientReadOnly client_ride = new Ride();
        DB db = new DB();
        String email = "omar1234";
        client_ride.requestRide(CurrentArea.MAADI,CurrentArea.NASRCITY,email,false);

        ArrayList<RequestRide> rq = new ArrayList<RequestRide>();
        rq = db.retrieveAllRequestedRides();

        assertEquals(CurrentArea.MAADI,rq.get(rq.size()-1).getPickUpLocation());
        assertEquals(CurrentArea.NASRCITY,rq.get(rq.size()-1).getDestination());
    }

    @Test
    public void TestUpdateCar() throws RemoteException {

        AdminReadOnly driver_car = new Car();
        DB db = new DB();
        String email = "ahmed1346";
        String carColor = "red";
        String carModel = "toyota";
        String plateNum = "NUM135";
        driver_car.updateCar(email, carModel, plateNum, carColor);
        Car expected_car = new Car("toyota", "NUM135", "red");
        Driver new_driver = new Driver();

        new_driver = db.retrieveDriverByMail(email);

        assertEquals(expected_car.getCarColor(), new_driver.getCar().getCarColor());
        assertEquals(expected_car.getCarModel(), new_driver.getCar().getCarModel());
        assertEquals(expected_car.getPlateNum(), new_driver.getCar().getPlateNum());
    }

    @Test
    public void TestUpdateBalance() throws RemoteException{

        Client client = new Client();
        DB db = new DB();
        client = db.retrieveClientByMail2("ahmed1134646");
        double amount = 30;
        double old_balance = client.getBankAcc().getBalance();
        client.getBankAcc().updateBalance(amount,client.getAcc().getEmail());

        client = db.retrieveClientByMail2("ahmed1134646");

        assertEquals(old_balance-amount,client.getBankAcc().getBalance(),0.00);
    }
}

