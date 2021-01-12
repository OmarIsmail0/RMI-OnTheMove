/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
/**
 *
 * @author Laptop Shop
 */
public interface BankAccountInterface extends Remote {
    public void updateBalance(double x,int y)  throws RemoteException;
    public void checkAccountBalance(double x,int y)  throws RemoteException;
    public void checkCCinfo(int x, double y, Date date)  throws RemoteException;
}
