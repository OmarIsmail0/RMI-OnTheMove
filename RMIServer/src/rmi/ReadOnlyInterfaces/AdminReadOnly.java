package rmi.ReadOnlyInterfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import rmi.AccType;

public interface AdminReadOnly extends Remote {
    public void createDriverAccount(String username,String password,String email,String mobile, AccType type) throws RemoteException;
    public boolean login(String EMAIL, String PW) throws RemoteException;
    public void editAccount() throws RemoteException;
    //public void viewAllAccounts() throws RemoteException;
    public void banAccount(String email) throws RemoteException;
    public void approveChanges() throws RemoteException;
    
}
