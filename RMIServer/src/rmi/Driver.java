package rmi;

import java.util.ArrayList;

public class Driver extends User{
    private String driverLicense;
    private ArrayList<AvailableTimes> workingTimes;
    private Car car;
    private Notification notification;
    
    //Constructor
    public Driver(Account acc, CurrentArea area, ArrayList<Ride> rides, BankAccount creditCard, float rating, String driverLicense, ArrayList<AvailableTimes> workingTimes, Car car) {
        super(acc, area, rides, creditCard, rating);
        this.car=car;
        this.driverLicense=driverLicense;
        this.workingTimes=workingTimes;
    }
    
    //Setters And Getters
    public String getDriverLicense() {
        return driverLicense;
    }
    public void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense;
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
