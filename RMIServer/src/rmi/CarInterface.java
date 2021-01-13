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
 * @author ADMIN
 */
public interface CarInterface extends Remote {
    public void updateCar(String CM, String PN, String CC) throws RemoteException;
    public void setCarModel(String carModel) throws RemoteException;
    public void setPlateNum(String plateNum) throws RemoteException; 
    public void setCarColor(String carColor) throws RemoteException;
}
