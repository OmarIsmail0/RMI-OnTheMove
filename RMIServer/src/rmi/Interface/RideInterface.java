
package rmi.Interface;
import rmi.Account;
import rmi.CurrentArea;
import rmi.RequestRide;
import rmi.Ride;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface RideInterface extends Remote {
    public void requestRide(CurrentArea PUL, CurrentArea DST, String email, boolean payOnline) throws RemoteException;
    public ArrayList<RequestRide> viewRideHistory(String email) throws RemoteException;
}
