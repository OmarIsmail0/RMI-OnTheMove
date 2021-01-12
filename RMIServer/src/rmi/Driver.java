package rmi;

import java.util.ArrayList;

public class Driver extends User{
    private String driverLicense;
    private boolean availability;
    private ArrayList<AvailableTimes> workingTimes;
    private Car car;
    private Notification notification;
    
    //Constructor
    public Driver(Account acc, Notification notif, CurrentArea area, ArrayList<Ride> rides, ArrayList<BankAccount> creditCards, float rating) {
        super(acc, notif, area, rides, creditCards, rating);
    }
    
    //Setters And Getters
    public String getDriverLicense() {
        return driverLicense;
    }
    public void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense;
    }
    public boolean isAvailability() {
        return availability;
    }
    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
    public ArrayList<AvailableTimes> getWorkingTimes() {
        return workingTimes;
    }
    public void setWorkingTimes(ArrayList<AvailableTimes> workingTimes) {
        this.workingTimes = workingTimes;
    }
    public Car getCar() {
        return car;
    }
    public void setCar(Car car) {
        this.car = car;
    }
    public Notification getNotification() {
        return notification;
    }
    public void setNotification(Notification notification) {
        this.notification = notification;
    }
    
    //Methods
    
}
