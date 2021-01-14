package rmi;

import rmi.Interface.AdminInterface;
import rmi.ReadOnly.AdminReadOnly;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


public class Admin extends UnicastRemoteObject implements AdminReadOnly {
    static Admin adminInstance;
    Account acc;
//    User user;
//    AdminReadOnly ARO
//    AdminReadOnly AI;

    Admin() throws RemoteException {

    }
    public Admin adminInstance() throws RemoteException{
        return null;
    }

    @Override
    public void createDriverAccount(String username, String password, String email, String mobile, AccType type, String driverLicense, ArrayList<AvailableTimes> workingTimes, String carModel, String plateNum, String carColor, float rating, CurrentArea currentArea) throws RemoteException {

    }
    @Override
    public String viewAllAccounts() throws RemoteException {
        return null;
    }
    @Override
    public boolean login(String email, String password) throws RemoteException {
        return false;
    }
    @Override
    public void banAccount(String email) throws RemoteException {

    }
    @Override
    public void editAccount() throws RemoteException {

    }
}
