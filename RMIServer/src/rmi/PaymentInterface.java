/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author Laptop Shop
 */
public interface PaymentInterface extends Remote {
     public void setAmount(int amount) throws RemoteException;;
     public void setMethod(PayMethod method) throws RemoteException;
}
