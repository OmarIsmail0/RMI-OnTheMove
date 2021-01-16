package rmi;

import rmi.Interface.RequestRideInterface;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RequestRide implements RequestRideInterface, Serializable {

    private int ride_id;
    private ArrayList<RequestRide> rr;
    private CurrentArea pickUpLocation;
    private CurrentArea destination;
    private double rideFees;
    private boolean payOnline;

    Account acc;
    Status status;

    public boolean isPayOnline() {
        return payOnline;
    }

    public void setPayOnline(boolean payOnline) {
        this.payOnline = payOnline;
    }

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
            if (ride.getValue().getStatus() == Status.PENDING)
                System.out.println(ride.getValue().getRide_id() + ". " + ride.getValue().getAcc().getUsername() + "/" + ride.getValue().getPickUpLocation()
                        + "/" + ride.getValue().getDestination() + "/" + ride.getValue().getStatus());
        }
        int choice = -1;
        int num = -1;
        while (true) {
            System.out.println("Select Ride");
            Scanner input = new Scanner(System.in);
            choice = input.nextInt();
            System.out.println("1. Accept.");
            System.out.println("2. Decline.");
            num = input.nextInt();
            for (Map.Entry<Integer, RequestRide> ride : rides.entrySet()) {
                if (ride.getValue().getRide_id() == choice && num == 1) {
                    acceptRide(ride.getValue());
                    test = true;
                    break;
                } else if (ride.getValue().getRide_id() == choice && num == 2) {
                    declineRide(ride.getValue());
                    test = true;
                    break;
                }
            }
            if (test) {
                break;
            }
        }
    }

    public void acceptRide(RequestRide ride) throws RemoteException {
        ArrayList<Notification> notif = new ArrayList<Notification>();
        Notification new_notif = new Notification();

        ride.setStatus(Status.ACCEPTED);
        Payment payCash = new Payment(new Cash());
        Payment payOnline = new Payment(new OnlinePayment());
        DB db = new DB();
        Client c = new Client();
        c = db.retrieveClientByMail2(ride.getAcc().getEmail());
        if (!ride.isPayOnline()) {
            payCash.executeStrategy(ride.getRideFees(), c.getBankAcc());
        } else {
            payOnline.executeStrategy(ride.getRideFees(), c.getBankAcc());
        }
        notif = db.retrieveAllNotifications();
        int index = 0;
        for (int i = 0; i < notif.size(); i++) {
            index = notif.get(i).getId();
        }
        index++;

        new_notif.setId(index);
        new_notif.setMessage("Ride From: " + ride.getPickUpLocation() + " To " + ride.getDestination() + " Has Been Accepted!");
        new_notif.setClient_email(c.getAcc().getEmail());
        db.insertNotification(new_notif);

        db.updateRequestRide(ride, ride.getRide_id());
    }


    public void declineRide(RequestRide ride) throws RemoteException {
        ride.setStatus(Status.DECLINED);
        DB db = new DB();
        db.updateRequestRide(ride, ride.getRide_id());
    }
}
