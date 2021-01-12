
package rmi;
import java.util.ArrayList;

/**
 *
 * @author Mai146607
 */
public class Ride {
   private int rideID;
   private String pickUpLoc;
   private String destination;
   private double rideFees;
   private Complaint comment;
   private Client client;
   private Driver driver;

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
   
   public void viewRideDetails(int x){
   }
   
   public void cancelRide(int x){
       
   }
   public void requestRide(String x, String y){
       
   }
   public ArrayList<Ride> viewRideHistory(){
       ArrayList<Ride> r = new ArrayList<Ride>();
       return r; 
   }
   public void acceptRide(int x){
       
   }
   public void declineRide(int x){
       
   }
}
