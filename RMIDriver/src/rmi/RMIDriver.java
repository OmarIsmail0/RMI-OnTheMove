package rmi;


import GUI.DriverLogin;
import GUI.SelectRide;
import rmi.Interface.RequestRideInterface;
import rmi.ReadOnly.*;


import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIDriver {

    public static void main(String[] args) {
        try{
            Registry registry = LocateRegistry.getRegistry(1500);

           // DriverReadOnly driver_ride = (DriverReadOnly) registry.lookup("Driver Ride");
            RequestRideInterface driver_select = (RequestRideInterface) registry.lookup("Select");
            DriverReadOnly driver_acc = (DriverReadOnly) registry.lookup("Driver Account");


            /*-----------------------------Accept/Decline Ride Request----------------------------------*/
           /* driver_acc.login("islam1134646","1346");
            driver_select.selectRide("islam1134646");*/
/*
            LoginWindowDriver driverGui = new LoginWindowDriver();
            driverGui.setLocationRelativeTo(null); // This makes the window appears centered
            driverGui.setVisible(true); // This shows the gui

            DriverLogin home = new DriverLogin(driverGui, registry);
            */
            DriverHome driverGui = new DriverHome();
            driverGui.setLocationRelativeTo(null); // This makes the window appears centered
            driverGui.setVisible(true); // This shows the gui

            SelectRide home = new SelectRide(driverGui, registry);

        }catch (Exception ex){
            ex.printStackTrace();
            System.out.println(ex);
        }
    }
    
}
