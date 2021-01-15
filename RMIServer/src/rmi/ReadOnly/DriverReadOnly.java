package rmi.ReadOnly;

import rmi.Account;
import rmi.Ride;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface DriverReadOnly extends Remote {
    /*Account*/
    public String viewOwnAccount(String email) throws RemoteException;
    public boolean login(String email, String password) throws RemoteException;

    /*Ride*/
    public void acceptRide(int x) throws RemoteException;
    public void declineRide(int x) throws RemoteException;
    public ArrayList<Ride> viewRideHistory() throws RemoteException;

    /*Complaint*/
    public void giveComplaint(String msg, int rideID, String email) throws RemoteException;

    /*Car*/
    public void updateCar(String mail ,String CM, String PN, String CC) throws RemoteException;
}
