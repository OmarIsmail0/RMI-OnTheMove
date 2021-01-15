package rmi.Interface;

import rmi.AccType;
import rmi.AvailableTimes;
import rmi.CurrentArea;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

public interface AccountInterface extends Remote  {

    public void createClientAccount(String username, String password, String email, String mobile, AccType type,
                                    double balance, String CCnumber, int ccv, Date expDate) throws RemoteException;
    public void createDriverAccount(String username, String password, String email, String mobile
            , AccType type, String driverLicense, ArrayList<AvailableTimes> workingTimes, String carModel, String plateNum, String carColor, float rating, CurrentArea currentArea) throws RemoteException;
    public String viewOwnAccount(String email) throws RemoteException;
    public String viewAllAccounts() throws RemoteException;
    public boolean login(String email, String password) throws RemoteException;
    public void banAccount(String email) throws RemoteException;
    public void sendVerification() throws RemoteException;
    public boolean enterVerificationCode(int code) throws RemoteException;

}
