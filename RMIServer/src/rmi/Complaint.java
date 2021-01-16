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
    private RequestRide ride;

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

    public RequestRide getRide() {
        return ride;
    }

    public void setRide(RequestRide ride) {
        this.ride = ride;
    }

    @Override
    public void giveComplaint(String msg, int rideID, String email) throws RemoteException {
        DB db = new DB();
        Complaint c = new Complaint();
        Account acc = new Account();

        acc = db.retrieveAccount(email);
        RequestRide ride = db.retrieveRide(rideID);

        System.out.println(ride.getRide_id()+"/ " +ride.getAcc().getAccID());
        System.out.println("acc: "+acc.getAccID());
        if (ride.getAcc().getAccID() == acc.getAccID()) {
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
    public String viewOwnAccount(String email) throws RemoteException {
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
    public void requestRide(CurrentArea PUL, CurrentArea DST, String email, boolean payOnline) throws RemoteException{

    }
    @Override
    public void cancelRide(int x) throws RemoteException {

    }
    @Override
    public void viewRideDetails(int x) throws RemoteException {

    }
    @Override
    public ArrayList<RequestRide> viewRideHistory(String email) throws RemoteException {
        return null;
    }

}
