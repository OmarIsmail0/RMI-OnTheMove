package rmi.ReadOnly;

import rmi.AccType;
import rmi.AvailableTimes;
import rmi.CurrentArea;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface AdminReadOnly extends Remote {
    /*Account*/
    public void createDriverAccount(String username, String password, String email, String mobile
            , AccType type, String driverLicense, ArrayList<AvailableTimes> workingTimes, String carModel, String plateNum, String carColor, float rating, CurrentArea currentArea) throws RemoteException;
    public String viewAllAccounts() throws RemoteException;
    public boolean login(String email, String password) throws RemoteException;
    public void banAccount(String email) throws RemoteException;

    /*Admin*/
    public void editAccount() throws RemoteException;
    /*Car*/
    public void updateCar(String mail ,String CM, String PN, String CC) throws RemoteException;

}
