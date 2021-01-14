package rmi;

import rmi.ReadOnly.DriverReadOnly;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class Driver extends User implements DriverReadOnly {
    private String driverLicense;
    private ArrayList<AvailableTimes> workingTimes;
    private Car car;
    private Notification notification;
    private CurrentArea area;

    //Constructor
    public Driver() throws RemoteException  {

    }

    public Driver(Account acc, ArrayList<Ride> rides, float rating, String driverLicense, ArrayList<AvailableTimes> workingTimes, Car car, CurrentArea area) throws RemoteException {
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

    /*Account*/
    @Override
    public String viewOwnAccount() throws RemoteException {
        return null;
    }
    @Override
    public boolean login(String email, String password) throws RemoteException {
        return false;
    }

    /*Ride*/
    @Override
    public void acceptRide(int x) throws RemoteException {

    }
    @Override
    public void declineRide(int x) throws RemoteException {

    }
    @Override
    public ArrayList<Ride> viewRideHistory() throws RemoteException {
        return null;
    }

    /*Complaint*/
    @Override
    public void giveComplaint(Account acc, String str, int rideID) throws RemoteException {

    }

    /*Car*/
    @Override
    public void updateCar(String mail, String CM, String PN, String CC) throws RemoteException {
    }

}
