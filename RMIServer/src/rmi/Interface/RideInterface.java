
package rmi.Interface;
import rmi.Ride;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface RideInterface extends Remote {
    public void viewRideDetails(int x) throws RemoteException;
    public void cancelRide(int x) throws RemoteException;
    public void requestRide(String x, String y) throws RemoteException;
    public ArrayList<Ride> viewRideHistory() throws RemoteException;
    public void acceptRide(int x) throws RemoteException;
    public void declineRide(int x) throws RemoteException;
   
}