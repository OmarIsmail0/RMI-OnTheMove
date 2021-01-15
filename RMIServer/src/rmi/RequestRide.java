package rmi;

import rmi.Interface.RequestRideInterface;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RequestRide implements RequestRideInterface, Serializable {

    int ride_id;
    ArrayList<RequestRide> rr;
    CurrentArea pickUpLocation;
    CurrentArea destination;
    double rideFees;
    Account acc;
    Status status;

    public RequestRide() {

    }

    public int getRide_id() {
        return ride_id;
    }

    public void setRide_id(int ride_id) {
        this.ride_id = ride_id;
    }

    public CurrentArea getPickUpLocation() {
        return pickUpLocation;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setPickUpLocation(CurrentArea pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    public CurrentArea getDestination() {
        return destination;
    }

    public void setDestination(CurrentArea destination) {
        this.destination = destination;
    }

    public Account getAcc() {
        return acc;
    }

    public void setAcc(Account acc) {
        this.acc = acc;
    }

    public double getRideFees() {
        return rideFees;
    }

    public void setRideFees(double rideFees) {
        this.rideFees = rideFees;
    }

    @Override
    public void selectRide(String email) throws RemoteException {
        Map<Integer, RequestRide> rides
                = new HashMap<Integer, RequestRide>();
        boolean test = false;

        DB db = new DB();
        Driver driver = db.retrieveDriverByMail(email);
        rr = db.retrieveAllRequestedRides();
        for (int i = 0; i < rr.size(); i++) {
            if (rr.get(i).getPickUpLocation() == driver.getArea()) {
                rides.put(i, rr.get(i));
            }
        }

        for (Map.Entry<Integer, RequestRide> ride : rides.entrySet()) {
            if(ride.getValue().getStatus() == Status.PENDING)
            System.out.println(ride.getValue().getRide_id() + ". " + ride.getValue().getAcc().getUsername() + "/" + ride.getValue().getPickUpLocation()
                    + "/" + ride.getValue().getDestination() + "/" + ride.getValue().getStatus());
        }
        int choice = -1;
        int num = -1;
        while (true) {
            System.out.println("Select Ride");
            Scanner input = new Scanner(System.in);
            choice = input.nextInt();
            System.out.println("1. to Accept.");
            System.out.println("2. to Decline.");
            num = input.nextInt();
            for (Map.Entry<Integer, RequestRide> ride : rides.entrySet()) {
                if (ride.getValue().getRide_id() == choice && num == 1) {
                    acceptRide(ride.getValue());
                   // db.updateRequestRide(ride.getValue(),ride.getValue().getAcc().getEmail());
                    test = true;
                    break;
                } else if (ride.getValue().getRide_id() == choice && num == 2) {
                    declineRide(ride.getValue());
                   // db.updateRequestRide(ride.getValue(),ride.getValue().getAcc().getEmail());
                    test = true;
                    break;
                }
            }
            if (test){
                break;
            }
        }
    }

    public void acceptRide(RequestRide ride) throws RemoteException {
        ride.setStatus(Status.ACCEPTED);
        DB db = new DB();
        db.updateRequestRide(ride,ride.getRide_id());
    }


    public void declineRide(RequestRide ride) throws RemoteException {
        ride.setStatus(Status.DECLINED);
        DB db = new DB();
        db.updateRequestRide(ride,ride.getRide_id());
    }
}
