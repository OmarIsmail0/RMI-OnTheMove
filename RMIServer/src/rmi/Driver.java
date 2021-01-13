package rmi;

import java.rmi.RemoteException;
import java.util.ArrayList;
import rmi.ReadOnlyInterfaces.DriverReadOnly;

public class Driver  extends User implements DriverReadOnly{
    private String driverLicense;
    private ArrayList<AvailableTimes> workingTimes;
    private Car car;
    private Notification notification;
    
    //Constructor
    public Driver(Account acc, CurrentArea area, ArrayList<Ride> rides, BankAccount creditCard, float rating ,String driverLicense, ArrayList<AvailableTimes> workingTimes, Car car) {
        super(acc, area, rides, creditCard, rating);
        this.driverLicense=driverLicense;
        this.workingTimes=workingTimes;
        this.car=car;
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

    @Override
    public void acceptRide(Ride r) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void declineRide(Ride r) throws RemoteException {
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
