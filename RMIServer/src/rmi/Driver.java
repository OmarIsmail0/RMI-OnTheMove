package rmi;

import java.util.ArrayList;

public class Driver extends User{
    private String driverLicense;
    private ArrayList<AvailableTimes> workingTimes;
    private Car car;
    private Notification notification;
    private CurrentArea area;

    //Constructor
    public Driver(){

    }

    public Driver(Account acc, ArrayList<Ride> rides, float rating, String driverLicense, ArrayList<AvailableTimes> workingTimes, Car car, CurrentArea area) {
        super(acc, rides, rating);
        this.area=area;
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

    public CurrentArea getArea() {
        return area;
    }

    public void setArea(CurrentArea area) {
        this.area = area;
    }
    //Methods
    
}
