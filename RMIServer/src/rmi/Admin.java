package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/*
- static adminInstance: Admin
- acc: Account
- user: User
- ARO: AdminReadOnly
- AI: AdminInterface

-  Admin()
+ static adminInstance(): Admin
+ editAccount():void

*/
public class Admin extends UnicastRemoteObject implements AdminInterface {
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
    public void editAccount() throws RemoteException{

    }
}
