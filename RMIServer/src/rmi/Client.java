package rmi;

import java.rmi.RemoteException;
import java.util.ArrayList;
import rmi.ReadOnlyInterfaces.ClientReadOnly;

public class Client extends User implements ClientReadOnly{
    //float wallet;
    int numOfRides;
    Ride ride;
    Notification notification;
    
    //Constructor
    public Client(Account acc, CurrentArea area, ArrayList<Ride> rides,BankAccount creditCard, float rating) {
        super(acc, area, rides, creditCard, rating);
        this.numOfRides = 0;
    }
    
    //Setter And Getters
    
    public int getNumOfRides() {
        return numOfRides;
    }
    public void setNumOfRides(int numOfRides) {
        this.numOfRides = numOfRides;
    }
    public Ride getRide() {
        return ride;
    }
    public void setRide(Ride ride) {
        this.ride = ride;
    }
    public Notification getNotification() {
        return notification;
    }
    public void setNotification(Notification notification) {
        this.notification = notification;
    }
    
    //Methods

    @Override
    public void createClientAccount(String username, String password, String email, String mobile, AccType type) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void requestRide(CurrentArea pickUpLoc, CurrentArea destination) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cancelRide(int Rid) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean enterVerificationCode(int code) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void viewRideDetails(int Rid) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Ride> viewRideHistory() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean login(String EMAIL, String PW) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void giveComplaint(Account acc, String str) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
