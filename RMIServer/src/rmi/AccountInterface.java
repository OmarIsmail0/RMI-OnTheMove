package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

public interface AccountInterface extends Remote  {

    public void createClientAccount(String username, String password, String email, String mobile, AccType type,
                                    double balance, String CCnumber, int ccv, Date expDate) throws RemoteException;
    public void createDriverAccount(String username, String password, String email, String mobile
            , AccType type, String driverLicense, ArrayList<AvailableTimes> workingTimes, float rating, CurrentArea currentArea) throws RemoteException;
    public void viewOwnAccount(String email) throws RemoteException;
    public void viewAllAccounts() throws RemoteException;
    public boolean login(String email, String password) throws RemoteException;
    public void banAccount(String email) throws RemoteException;
    public void sendVerification() throws RemoteException;
    public boolean enterVerificationCode(int code) throws RemoteException;
    public void approveChanges() throws RemoteException;

}
