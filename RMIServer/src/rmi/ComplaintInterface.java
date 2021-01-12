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
public interface ComplaintInterface extends Remote {
        public void giveComplaint(Account acc ,String str) throws RemoteException;
}
