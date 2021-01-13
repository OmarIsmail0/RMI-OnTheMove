/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;
import rmi.Interface.FacadeInterface;

import java.util.ArrayList;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
/**
 *
 * @author USCS
 */
public class AccountFacade extends UnicastRemoteObject implements FacadeInterface {
    Account a;
    ArrayList<Account> acc; 
    public AccountFacade() throws RemoteException {
        a= new Account(0,"","","","",AccType.CLIENT,acc);
    }
    @Override
    public void SetAccountData(int id, String username, String password, String email, String mobile, AccType type, ArrayList<Account> acc) throws RemoteException{
        a.setAccID(id);
        a.setUsername(username);
        a.setPassword(password);
        a.setEmail(email);
        a.setMobile(mobile);
        a.setAcc(acc);
        a.setType(type);
    }
    
    @Override
    public String getAccountData() throws RemoteException{
        String AccountData= a.getUsername()+ a.getPassword()+ a.getEmail() + a.getMobile() + a.getAccID() + a.getType();
        //may cause error when we implement bec string and contains many getter types
        return AccountData;
    }
    
    @Override
    public Account getAccount() throws RemoteException {
        
        Account acc =new Account(a.getAccID(),a.getUsername(), a.getPassword(),a.getEmail(),a.getMobile(), a.getType(), a.getAcc());
        return acc;
    }
}
