package rmi;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/*

- accID: int
- username:String
- password: String
- email:String
- mobile: String
- type: AccType
+ acc:ArrayList<Account>
+ verificationCode: static int
+ accessType: static AccType

+ createClientAccount(String,String,String,String,AccType):void
+ createDriverAccount(String,String,String,String,AccType):void
+ viewAccount():void
+ login(String,String):boolean
+ banAccount(String):void
+ sendVerification():void
+ enterVerificationCode(int):boolean
+ approveChanges(): void

*/

public class Account extends UnicastRemoteObject implements AccountInterface {
    int accID;
    String username, password, email, mobile;
//    AccType type;
    public ArrayList<Account> acc;
    public static int verificationCode;
//    public static AccType accessType;

    public Account() throws RemoteException{

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

//    public AccType getType() {
//        return type;
//    }

//    public void setType(AccType type) {
//        this.type = type;
//    }

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

//    public static AccType getAccessType() {
//        return accessType;
//    }

//    public static void setAccessType(AccType accessType) {
//        Account.accessType = accessType;
//    }

    @Override
    public void createClientAccount(String username,String password,String email,String mobile/*,AccType type*/) throws RemoteException{

    }
    @Override
    public void createDriverAccount(String username,String password,String email,String mobile/*,AccType type*/) throws RemoteException{

    }
    @Override
    public void viewAccount() throws RemoteException{
    }
    @Override
    public boolean login(String email, String password) throws RemoteException{
        return true;
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

}
