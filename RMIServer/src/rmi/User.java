package rmi;

import java.util.ArrayList;

public class User {
    private Account acc;
    private Notification notif;
    private ArrayList<Ride> rides;
    private float rating;

    //Constructors

    public User() {
    }

    public User(Account acc, ArrayList<Ride> rides, float rating) {
        this.acc = acc;
        this.rides = rides;
        this.rating = rating;
    }

    //Setters & Getters
    public Account getAcc() {
        return acc;
    }
    public void setAcc(Account acc) {
        this.acc = acc;
    }
    public Notification getNotif() {
        return notif;
    }
    public void setNotif(Notification notif) {
        this.notif = notif;
    }
 /*   public CurrentArea getArea() {
        return area;
    }
    public void setArea(CurrentArea area) {
        this.area = area;
    }*/
    public ArrayList<Ride> getRides() {
        return rides;
    }
    public void setRides(ArrayList<Ride> rides) {
        this.rides = rides;
    }
    public float getRating() {
        return rating;
    }
    public void setRating(float rating) {
        this.rating = rating;
    }
    
    //Methods
    public void reportUser(int id){
        
    }
    public void rateUser(int id, float rate){
        
    }
    public void viewUserRating(int id){
        
    }
}
