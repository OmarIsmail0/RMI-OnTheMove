package rmi;


import rmi.Interface.RequestRideInterface;
import rmi.ReadOnly.*;


import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIDriver {

    public static void main(String[] args) {
        try{
            Registry registry = LocateRegistry.getRegistry(1199);

           // DriverReadOnly driver_ride = (DriverReadOnly) registry.lookup("Driver Ride");
            RequestRideInterface driver_select = (RequestRideInterface) registry.lookup("Select");
            DriverReadOnly driver_acc = (DriverReadOnly) registry.lookup("Driver Account");


            /*-----------------------------Accept/Decline Ride Request----------------------------------*/
            driver_acc.login("islam1134646","1346");
            driver_select.selectRide("islam1134646");


        }catch (Exception ex){
            ex.printStackTrace();
            System.out.println(ex);
        }
    }
    
}
