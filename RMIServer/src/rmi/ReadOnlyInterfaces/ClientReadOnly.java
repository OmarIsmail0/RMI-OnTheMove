package rmi.ReadOnlyInterfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import rmi.AccType;
import rmi.Account;
import rmi.CurrentArea;
import rmi.Ride;

public interface ClientReadOnly extends Remote{
    public void createClientAccount(String username,String password,String email,String mobile,AccType type) throws RemoteException;
    //public void viewOwnAccount() throws RemoteException;
    public void requestRide(CurrentArea pickUpLoc, CurrentArea destination)throws RemoteException;
    public void cancelRide(int Rid)throws RemoteException;
    public boolean enterVerificationCode(int code) throws RemoteException;
    public void viewRideDetails(int Rid)throws RemoteException;
    public ArrayList<Ride> viewRideHistory() throws RemoteException;
    public boolean login(String EMAIL, String PW) throws RemoteException;
    public void giveComplaint(Account acc ,String str) throws RemoteException;
}
