package rmi.Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CarInterface extends Remote{
    public void updateCar(String mail ,String CM, String PN, String CC) throws RemoteException;
}
