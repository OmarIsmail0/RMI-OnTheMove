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
 * @author USCS
 */
public interface NotificationCenterInterface extends Remote{
     public void notifyObservers() throws RemoteException;
     public void addObserver(Observer observer) throws RemoteException;
}
