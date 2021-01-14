package rmi;

import rmi.ReadOnly.ClientReadOnly;
import rmi.ReadOnly.DriverReadOnly;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class Complaint implements ClientReadOnly, DriverReadOnly {

    private int cmpID;
    private Account acc;
    private String msg;
    private Ride ride;

    public int getCmpID() {
        return cmpID;
    }

    public void setCmpID(int cmpID) {
        this.cmpID = cmpID;
    }

    public Account getAcc() {
        return acc;
    }

    public void setAcc(Account acc) {
        this.acc = acc;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Ride getRide() {
        return ride;
    }

    public void setRide(Ride ride) {
        this.ride = ride;
    }

    @Override
    public void giveComplaint(Account acc, String str, int rideID) throws RemoteException {
        DB db = new DB();
        Complaint c = new Complaint();
        Ride ride = db.retrieveRide(rideID);
        AccType type = acc.getType();
        if (type == AccType.CLIENT) {
            if (ride.getClient().getAcc().getAccID() == acc.getAccID()) {
                c.setMsg(str);
                c.setAcc(acc);
                c.setRide(ride);
                db.insertComplaint(c);
            }
        } else if (type == AccType.DRIVER) {
            if (ride.getDriver().getAcc().getAccID() == acc.getAccID()) {
                c.setMsg(str);
                c.setAcc(acc);
                c.setRide(ride);
                db.insertComplaint(c);
            }
        }

    }

    /*Account*/
    @Override
    public void createClientAccount(String username, String password, String email, String mobile, AccType type, double balance, String CCnumber, int ccv, Date expDate) throws RemoteException {

    }
    @Override
    public String viewOwnAccount() throws RemoteException {
        return null;
    }
    @Override
    public boolean login(String email, String password) throws RemoteException {
        return false;
    }
    @Override
    public void editAccount() throws RemoteException {

    }

    /*Ride*/
    @Override
    public void acceptRide(int x) throws RemoteException {

    }
    @Override
    public void declineRide(int x) throws RemoteException {

    }
    @Override
    public void requestRide(String x, String y) throws RemoteException {

    }
    @Override
    public void cancelRide(int x) throws RemoteException {

    }
    @Override
    public void viewRideDetails(int x) throws RemoteException {

    }
    @Override
    public ArrayList<Ride> viewRideHistory() throws RemoteException {
        return null;
    }

    /*Car*/
    @Override
    public void updateCar(String mail, String CM, String PN, String CC) throws RemoteException {

    }
}
