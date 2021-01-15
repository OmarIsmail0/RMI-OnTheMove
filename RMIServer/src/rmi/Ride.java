
package rmi;

import rmi.Interface.RideInterface;
import rmi.ReadOnly.ClientReadOnly;
import rmi.ReadOnly.DriverReadOnly;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ride implements ClientReadOnly, DriverReadOnly, RideInterface, Serializable {

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
    public void viewRideDetails(int x) {

    }

    @Override
    public void cancelRide(int x) {
    }

    @Override
    public void acceptRide(int x) throws RemoteException {

    }

    @Override
    public void declineRide(int x) throws RemoteException {

    }

    @Override
    public void requestRide(CurrentArea PUL, CurrentArea DST, String email) throws RemoteException {
        try {

            Map<Integer, CurrentArea> rides
                    = new HashMap<Integer, CurrentArea>();

            /*for (int i = 0; i < CurrentArea.size(); i++) {
                if (rr.get(i).getPickUpLocation() == driver.getArea()) {
                    rides.put(i, rr.get(i));
                }
            }*/

            ArrayList<RequestRide> result = new ArrayList();
            RequestRide rq = new RequestRide();
            DB db = new DB();
            Account acc = new Account();

            result = db.retrieveAllRides();

            int index = 0;
            for (int i = 0; i < result.size(); i++) {
                index = result.get(i).getRide_id();
            }
            index++;

            acc = db.retrieveOneAccount(email);

            rq.setRide_id(index);
            rq.setAcc(acc);
            rq.setDestination(DST);
            rq.setPickUpLocation(PUL);
            //rq.setRideFees();
            rq.setStatus(Status.PENDING);

            System.out.println("Requested Ride:"+display(rq));
            db.insertRide(rq);

        } catch (Exception ex) {
            Logger.getLogger(Ride.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    public ArrayList<Ride> viewRideHistory() {
        ArrayList<Ride> r = new ArrayList<Ride>();
        return r;
    }

    @Override
    public void giveComplaint(String msg, int rideID, String email) throws RemoteException {

    }

    @Override
    public void updateCar(String mail, String CM, String PN, String CC) throws RemoteException {

    }

    /*Account*/
    @Override
    public void createClientAccount(String username, String password, String email, String mobile, AccType type, double balance, String CCnumber, int ccv, Date expDate) throws RemoteException {

    }

    @Override
    public String viewOwnAccount(String email) throws RemoteException {
        return null;
    }

    @Override
    public boolean login(String email, String password) throws RemoteException {
        return false;
    }

    @Override
    public void editAccount() throws RemoteException {

    }

    @Override
    public String toString() {
        return "Ride{" +
                "rideID=" + getRideID() +
                ", pickUpLoc='" + pickUpLoc + '\'' +
                ", destination='" + destination + '\'' +
                ", rideFees=" + rideFees +
                '}';
    }

    public String display(RequestRide ride) {
        return "Ride ID: " + ride.getRide_id() +
                ", pickUpLoc: '" + ride.getPickUpLocation() + '\'' +
                ", destination: '" + ride.getDestination() + '\'' +
                ", Status: '" + ride.getStatus() + '\'' +
//                ", rideFees=" + rideFees +
                '}';
    }
}
