package rmi;

import java.util.ArrayList;

public class Client extends User{
    float wallet;
    int numOfRides;
    Ride ride;
    Notification notification;
    
    //Constructor
    public Client(Account acc, Notification notif, CurrentArea area, ArrayList<Ride> rides, ArrayList<BankAccount> creditCards, float rating) {
        super(acc, notif, area, rides, creditCards, rating);
    }
    
    //Setter And Getters
    public float getWallet() {
        return wallet;
    }
    public void setWallet(float wallet) {
        this.wallet = wallet;
    }
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
    
}
