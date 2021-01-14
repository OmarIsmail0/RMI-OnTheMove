package rmi.ReadOnly;

import rmi.AccType;
import rmi.Account;
import rmi.Ride;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

public interface ClientReadOnly extends Remote {
    /*Account*/
    public void createClientAccount(String username, String password, String email, String mobile, AccType type,
                                    double balance, String CCnumber, int ccv, Date expDate) throws RemoteException;

    public String viewOwnAccount() throws RemoteException;
    public boolean login(String email, String password) throws RemoteException;

    /*Ride*/
    public void requestRide(String x, String y) throws RemoteException;
    public void cancelRide(int x) throws RemoteException;
    public void viewRideDetails(int x) throws RemoteException;
    public ArrayList<Ride> viewRideHistory() throws RemoteException;

    /*Compliant*/
    public void giveComplaint(Account acc, String str, int rideID) throws RemoteException;

    /*Client*/
    public void editAccount() throws RemoteException;
}
