package rmi;

import rmi.ReadOnly.DriverReadOnly;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class Driver extends User {
    private String driverLicense;
    private ArrayList<AvailableTimes> workingTimes;
    private Car car;
    private Notification notification;
    private CurrentArea area;


    private DriverReadOnly DRO;

    public Driver(DriverReadOnly DRO) throws RemoteException{
        this.DRO = DRO;
    }
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

    public String viewOwnAccount() throws RemoteException {
        return DRO.viewOwnAccount();
    }

    public boolean login(String email, String password) throws RemoteException {
        return DRO.login(email, password);
    }

    /*Ride*/

    public void acceptRide(int x) throws RemoteException {
        DRO.acceptRide(x);
    }

    public void declineRide(int x) throws RemoteException {
        DRO.declineRide(x);
    }

    public ArrayList<Ride> viewRideHistory() throws RemoteException {
        return DRO.viewRideHistory();
    }

    /*Complaint*/

    public void giveComplaint(String msg, int rideID) throws RemoteException {
        DRO.giveComplaint(msg, rideID);
    }

    /*Car*/
    public void updateCar(String mail, String CM, String PN, String CC) throws RemoteException {
        DRO.updateCar(mail, CM, PN, CC);
    }
}
