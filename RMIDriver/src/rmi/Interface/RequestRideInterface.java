package rmi.Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RequestRideInterface extends Remote  {
    public void select() throws RemoteException;
}
