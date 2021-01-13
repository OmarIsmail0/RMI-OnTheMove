package rmi;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Mai146607
 */
public class Ride extends UnicastRemoteObject implements RideInterface, Serializable {

    private int rideID;
    private CurrentArea pickUpLoc;
    private CurrentArea destination;
    private double rideFees;
    private Complaint comment;
    private Client client;
    private Driver driver;

    public Ride() {
    }
    public Ride(int rideID, CurrentArea pickUpLoc, CurrentArea destination, double rideFees, Complaint comment, Client client, Driver driver) throws RemoteException {
        this.rideID = rideID;
        this.pickUpLoc = pickUpLoc;
        this.destination = destination;
        this.rideFees = rideFees;
        this.comment = comment;
        this.client = client;
        this.driver = driver;
    }

    public int getRideID() {
        return rideID;
    }

    public void setRideID(int rideID) {
        this.rideID = rideID;
    }

    public CurrentArea getPickUpLoc() {
        return pickUpLoc;
    }

    public void setPickUpLoc(CurrentArea pickUpLoc) {
        this.pickUpLoc = pickUpLoc;
    }

    public CurrentArea getDestination() {
        return destination;
    }

    public void setDestination(CurrentArea destination) {
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

    @Override
    public void viewRideDetails(int Rid) throws RemoteException {
    }

    @Override
    public void cancelRide(int Rid) throws RemoteException {

    }

    @Override
    public void requestRide(CurrentArea pickUpLoc, CurrentArea destination) throws RemoteException {
        //Ride r = new Ride();
    }

    @Override
    public ArrayList<Ride> viewRideHistory() throws RemoteException {
        ArrayList<Ride> r = new ArrayList<Ride>();
        return r;
    }

    @Override
    public void acceptRide(Ride r) throws RemoteException {

    }

    @Override
    public void declineRide(Ride r) throws RemoteException {

    }
}
