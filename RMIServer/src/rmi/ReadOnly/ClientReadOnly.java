package rmi.ReadOnly;

import rmi.*;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

public interface ClientReadOnly extends Remote {
    /*Account*/
    public void createClientAccount(String username, String password, String email, String mobile, AccType type,
                                    double balance, String CCnumber, int ccv, Date expDate) throws RemoteException;

    public String viewOwnAccount(String email) throws RemoteException;
    public boolean login(String email, String password) throws RemoteException;

    /*Ride*/
    public void requestRide(CurrentArea PUL, CurrentArea DST, String email, boolean payOnline) throws RemoteException;
    public ArrayList<RequestRide> viewRideHistory(String email) throws RemoteException;

    /*Compliant*/
    public void giveComplaint(String msg, int rideID, String email) throws RemoteException;

    /*Client*/
    public void editAccount() throws RemoteException;

    /*Notification*/
    public String viewNotifications(String email) throws RemoteException;
    public void clearNotification(String email) throws RemoteException;
}
