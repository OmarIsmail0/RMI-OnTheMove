package rmi;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Account extends UnicastRemoteObject implements AccountInterface, Serializable {
    int accID;
    String username, password, email, mobile;
    AccType type;
    public ArrayList<Account> acc;
    public static int verificationCode;

    public Account() throws RemoteException{

    }
    
    

    public Account(int accID, String username, String password, String email, String mobile, AccType type, ArrayList<Account> acc) throws RemoteException {
        this.accID = accID;
        this.username = username;
        this.password = password;
        this.email = email;
        this.mobile = mobile;
        this.type = type;
        this.acc = acc;
    }

    public int getAccID() {
        return accID;
    }

    public void setAccID(int accID) {
        this.accID = accID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public AccType getType() {
        return type;
    }

    public void setType(AccType type) {
        this.type = type;
    }

    public ArrayList<Account> getAcc() {
        return acc;
    }

    public void setAcc(ArrayList<Account> acc) {
        this.acc = acc;
    }

    public static int getVerificationCode() {
        return verificationCode;
    }

    public static void setVerificationCode(int verificationCode) {
        Account.verificationCode = verificationCode;
    }

    @Override
    public void createClientAccount(String username,String password,String email,String mobile,AccType type) throws RemoteException{
        Account newAccount = new Account();
    }
    /*
    @Override
    public void createDriverAccount(String username,String password,String email,String mobile, AccType type) throws RemoteException{

    }
    */
    @Override
    public void viewAccount() throws RemoteException{
        
    }
    @Override
    public boolean login(String EMAIL, String PW) throws RemoteException{
        if(email.equals(EMAIL) && password.equals(PW)) return true;
        else return false;
    }
    @Override
    public void banAccount(String email) throws RemoteException{
        
    }
    @Override
    public void sendVerification() throws RemoteException{

    }
    @Override
    public boolean enterVerificationCode(int code) throws RemoteException{
        return true;
    }
    @Override
    public void approveChanges() throws RemoteException{

    }
    
    @Override
    public String toString() {
        String result = "Name: " + username
                + "\nEmail: " + email
                + "\nYear: " + mobile;
        return result;

    }
}
