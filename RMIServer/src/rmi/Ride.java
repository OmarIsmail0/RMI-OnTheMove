
package rmi;

import rmi.Interface.RideInterface;
import rmi.ReadOnly.ClientReadOnly;
import rmi.ReadOnly.DriverReadOnly;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.*;
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
    public void requestRide(CurrentArea PUL, CurrentArea DST, String email, boolean payOnline) throws RemoteException {
        try {

            Map<Integer, CurrentArea> fees
                    = new HashMap<Integer, CurrentArea>();

            fees.put(1, CurrentArea.NEWCAIRO);
            fees.put(2, CurrentArea.MADINTYSHEROUK);
            fees.put(3, CurrentArea.NASRCITY);
            fees.put(4, CurrentArea.ZAMALEK);
            fees.put(5, CurrentArea.MAADI);

            double pickupFee = 0;
            double dstFee = 0;
            for (Map.Entry<Integer, CurrentArea> fee : fees.entrySet()) {
                if (fee.getValue() == PUL)
                    pickupFee = fee.getKey();
                if (fee.getValue() == DST)
                    dstFee = fee.getKey();
            }

            double ride_Fees = pickupFee * dstFee * 2.6;

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
            rq.setRideFees(ride_Fees);
            rq.setPayOnline(payOnline);

            rq.setStatus(Status.PENDING);
            if (payOnline) {
                Scanner sc = new Scanner(System.in);

                BankAccount bankAcc = new BankAccount();

                System.out.println("Enter ccNum: ");
                String ccNum = sc.nextLine();
                System.out.println("Enter ccv: ");
                int ccv = sc.nextInt();

                bankAcc.checkCCinfo(ccNum, ccv, email);
                System.out.println("Requested Ride:" + display(rq));
                db.insertRide(rq);

            } else {
                System.out.println("Requested Ride:" + display(rq));
                db.insertRide(rq);
            }

        } catch (
                Exception ex) {
            Logger.getLogger(Ride.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    @Override
    public ArrayList<RequestRide> viewRideHistory(String email) throws RemoteException{

        ArrayList<RequestRide> r = new ArrayList<RequestRide>();
        DB db = new DB();

        r = db.retrieveAllRequestedRidesByMail( email);
        for (int i = 0; i < r.size(); i++) {
            System.out.println(display(r.get(i)));
        }

        return r;
    }

    public String display(RequestRide ride) {
        return "Ride ID: " + ride.getRide_id()
                + ", pickUpLoc: '" + ride.getPickUpLocation() + '\''
                + ", destination: '" + ride.getDestination() + '\''
                + ", Status: '" + ride.getStatus() + '\''
                + ", rideFees=" + ride.getRideFees()
                + '}';
    }

    @Override
    public void giveComplaint(String msg, int rideID, String email) throws RemoteException {

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
    public String viewNotifications(String email) throws RemoteException {
        return null;
    }

    @Override
    public void clearNotification(String email) throws RemoteException {

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

}
