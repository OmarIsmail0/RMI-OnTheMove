package rmi;

import rmi.ReadOnlyInterfaces.AdminReadOnly;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


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
    public void createDriverAccount(String username, String password, String email, String mobile, AccType type) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean login(String EMAIL, String PW) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editAccount() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void banAccount(String email) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void approveChanges() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
