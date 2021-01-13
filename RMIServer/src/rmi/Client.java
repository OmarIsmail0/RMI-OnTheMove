package rmi;

import java.util.ArrayList;

public class Client extends User{
    int numOfRides;
    Ride ride;
    Notification notification;
    BankAccount bankAcc;

    //Constructor

    public Client() {

    }

    public Client(Account acc, CurrentArea area, ArrayList<Ride> rides, BankAccount creditCard, float rating, BankAccount bankAcc) {
        super(acc, area, rides, creditCard, rating);
        this.bankAcc=bankAcc;
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

    public BankAccount getBankAcc() {
        return bankAcc;
    }

    public void setBankAcc(BankAccount bankAcc) {
        this.bankAcc = bankAcc;
    }
    //Methods
    
}
