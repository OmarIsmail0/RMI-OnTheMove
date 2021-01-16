package rmi.ReadOnly;

import rmi.Account;
import rmi.RequestRide;
import rmi.Ride;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface DriverReadOnly extends Remote {
    /*Account*/
    public String viewOwnAccount(String email) throws RemoteException;
    public boolean login(String email, String password) throws RemoteException;

    /*Ride*/
    public ArrayList<RequestRide> viewRideHistory(String email) throws RemoteException;

    /*Complaint*/
    public void giveComplaint(String msg, int rideID, String email) throws RemoteException;


}
