package rmi;

import java.util.Scanner;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Mai146607
 */
public class Complaint {

    private int cmpID;
    private Account acc;
    private String msg;
    private Ride ride;

    public int getCmpID() {
        return cmpID;
    }

    public void setCmpID(int cmpID) {
        this.cmpID = cmpID;
    }

    public Account getAcc() {
        return acc;
    }

    public void setAcc(Account acc) {
        this.acc = acc;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Ride getRide() {
        return ride;
    }

    public void setRide(Ride ride) {
        this.ride = ride;
    }

    public void giveComplaint(Account acc, String str, int rideID) throws RemoteException {
        DB db = new DB();
        Complaint c = new Complaint();
        Ride ride = db.retrieveRide(rideID);
        AccType type = acc.getType();
        if (type == AccType.CLIENT) {
            if (ride.getClient().getAcc().getAccID() == acc.getAccID()) {
                c.setMsg(str);
                c.setAcc(acc);
                c.setRide(ride);
                db.insertComplaint(c);
            }
        } else if (type == AccType.DRIVER) {
            if (ride.getDriver().getAcc().getAccID() == acc.getAccID()) {
                c.setMsg(str);
                c.setAcc(acc);
                c.setRide(ride);
                db.insertComplaint(c);
            }
        }

    }
}
