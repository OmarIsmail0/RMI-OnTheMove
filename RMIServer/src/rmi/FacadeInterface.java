/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author USCS
 */

public interface FacadeInterface extends Remote{
    
   public void SetAccountData(int id, String username, String password, 
           String email, String mobile, AccType type, ArrayList<Account> acc)throws RemoteException;
   public String getAccountData()throws RemoteException;
   public Account getAccount() throws RemoteException;
   
}
