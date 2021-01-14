
package rmi;
import rmi.ReadOnly.ClientReadOnly;
import rmi.ReadOnly.DriverReadOnly;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

public class Ride implements ClientReadOnly, DriverReadOnly{
   private int rideID;
   private String pickUpLoc;
   private String destination;
   private double rideFees;
   private Complaint comment;
   private Client client;
   private Driver driver;

    /*Setters/Getters*/
    public int getRideID() {
        return rideID;
    }
    public void setRideID(int rideID) {
        this.rideID = rideID;
    }
    public String getPickUpLoc() {
        return pickUpLoc;
    }
    public void setPickUpLoc(String pickUpLoc) {
        this.pickUpLoc = pickUpLoc;
    }
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public double getRideFees() {
        return rideFees;
    }
    public void setRideFees(double rideFees) {
        this.rideFees = rideFees;
    }
    public Complaint getComment() {
        return comment;
    }
    public void setComment(Complaint comment) {
        this.comment = comment;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public Driver getDriver() {
        return driver;
    }
    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    /*Ride*/
    @Override
    public void viewRideDetails(int x){
    }
    @Override
    public void cancelRide(int x){
    }
    @Override
    public void acceptRide(int x) throws RemoteException {

    }
    @Override
    public void declineRide(int x) throws RemoteException {

    }
    @Override
    public void requestRide(String x, String y){
       
    }
    @Override
    public ArrayList<Ride> viewRideHistory(){
       ArrayList<Ride> r = new ArrayList<Ride>();
       return r; 
    }
    @Override
    public void giveComplaint(Account acc, String str, int rideID) throws RemoteException {

    }
    @Override
    public void updateCar(String mail, String CM, String PN, String CC) throws RemoteException {

    }

    /*Account*/
    @Override
    public void createClientAccount(String username, String password, String email, String mobile, AccType type, double balance, String CCnumber, int ccv, Date expDate) throws RemoteException {

    }
    @Override
    public String viewOwnAccount() throws RemoteException {
        return null;
    }
    @Override
    public boolean login(String email, String password) throws RemoteException {
        return false;
    }
    @Override
    public void editAccount() throws RemoteException {

    }

}
