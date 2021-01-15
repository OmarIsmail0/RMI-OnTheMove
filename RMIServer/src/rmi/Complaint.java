package rmi;

import rmi.ReadOnly.ClientReadOnly;
import rmi.ReadOnly.DriverReadOnly;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class Complaint implements ClientReadOnly, DriverReadOnly, Serializable {

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
    public void giveComplaint(String msg, int rideID) throws RemoteException {
        DB db = new DB();
        Complaint c = new Complaint();
        Account acc = new Account();
        //Error
        acc = db.retrieveAccount(Account.Client_acc_type, Account.Client_Login_Mail);
        Ride ride = db.retrieveRide(rideID);


        if (ride.getClient().getAcc().getAccID() == acc.getAccID()) {
            c.setMsg(msg);
            c.setAcc(acc);
            c.setRide(ride);
            db.insertComplaint(c);
        }else{
            System.out.println("User was never in the ride!");
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
    public void requestRide(CurrentArea PUL, CurrentArea DST) throws RemoteException {

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
