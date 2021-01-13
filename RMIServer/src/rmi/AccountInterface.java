package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AccountInterface extends Remote {

    public void createClientAccount(String username,String password,String email,String mobile,AccType type) throws RemoteException;
    public void createDriverAccount(String username,String password,String email,String mobile,AccType type) throws RemoteException;
    public void viewAccount(String email) throws RemoteException;
    public boolean login(String email, String password) throws RemoteException;
    public void banAccount(String email) throws RemoteException;
    public void sendVerification() throws RemoteException;
    public boolean enterVerificationCode(int code) throws RemoteException;
    public void approveChanges() throws RemoteException;

}
