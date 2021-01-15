package rmi;

import rmi.Interface.ClientInterface;
import rmi.Interface.DriverInterface;
import rmi.ReadOnly.ClientReadOnly;

import rmi.ReadOnly.*;
import rmi.Interface.ClientInterface;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
/*          DriverReadOnly driver_comp = new Complaint();
            DriverReadOnly driver_ride = new Ride();
            DriverReadOnly driver_car = new Car();

            registry.bind("Driver Complaint", driver_comp);
            registry.bind("Driver Ride", driver_ride);
            registry.bind("Driver Car", driver_car);
*/
public class RMIDriver {

    public static void main(String[] args) {
        try{
            Registry registry = LocateRegistry.getRegistry(1099);

            DriverReadOnly driver_ride = (DriverReadOnly) registry.lookup("Driver Ride");
            RequestRide driver_select = (RequestRide) registry.lookup("Select");
            DriverReadOnly driver_acc = (DriverReadOnly) registry.lookup("Driver Account");
            driver_acc.login("ahmed1346","1346");

            driver_select.selectRide("ahmed1346");
//           driver_ride.acceptRide();

/*          DriverReadOnly client_acc = (ClientReadOnly) registry.lookup("Client Account");
            DriverInterface client = (ClientInterface) registry.lookup("Client");
            ClientReadOnly client_ride = (ClientReadOnly) registry.lookup("Client Ride");*/
        }catch (Exception ex){
            ex.printStackTrace();
            System.out.println(ex);
        }
    }
    
}
