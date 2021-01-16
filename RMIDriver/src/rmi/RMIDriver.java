package rmi;


import rmi.Interface.RequestRideInterface;
import rmi.ReadOnly.*;


import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIDriver {

    public static void main(String[] args) {
        try{
            Registry registry = LocateRegistry.getRegistry(1199);

            DriverReadOnly driver_ride = (DriverReadOnly) registry.lookup("Driver Ride");
            RequestRideInterface driver_select = (RequestRideInterface) registry.lookup("Select");
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
