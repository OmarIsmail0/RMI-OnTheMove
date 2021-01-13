package rmi.ReadOnlyInterfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import rmi.Account;
import rmi.Ride;

public interface DriverReadOnly extends Remote{
    //public void viewOwnAccount() throws RemoteException;
    public void acceptRide(Ride r) throws RemoteException;
    public void declineRide(Ride r) throws RemoteException;
    public ArrayList<Ride> viewRideHistory() throws RemoteException;
    public boolean login(String EMAIL, String PW) throws RemoteException;
    public void giveComplaint(Account acc ,String str) throws RemoteException;
}
