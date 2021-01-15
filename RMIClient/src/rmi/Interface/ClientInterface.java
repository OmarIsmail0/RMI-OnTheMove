package rmi.Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientInterface extends Remote {
    public void editAccount() throws RemoteException;
}
