package rmi;


import rmi.Interface.*;
import rmi.ReadOnly.*;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(1500);

            DB db = new DB();

            Account acc = new Account();
            Complaint comp = new Complaint();
            Ride ride = new Ride();

            /*Client*/
            ClientReadOnly client_acc = new Account();
            ClientInterface client = new Client();
            ClientReadOnly client_comp = new Complaint();
            ClientReadOnly client_ride = new Ride();
            ClientReadOnly client_notify = new Notification();


            registry.bind("Client Account", client_acc);
            registry.bind("Client", client);
            registry.bind("Client Complaint", client_comp);
            registry.bind("Client Ride", client_ride);
            registry.bind("Client Notify", client_notify);

            /*Driver*/
            DriverReadOnly driver_acc = new Account();
            DriverReadOnly driver_comp = new Complaint();
            DriverReadOnly driver_ride = new Ride();

            RequestRideInterface driver_select = new RequestRide();

            registry.bind("Driver Account", driver_acc);
            registry.bind("Driver Complaint", driver_comp);
            registry.bind("Driver Ride", driver_ride);
            registry.bind("Select", driver_select);

            /*Admin*/
            AdminReadOnly admin_acc = new Account();
            AdminInterface admin = new Admin();
            AdminReadOnly admin_car = new Car();

            registry.bind("Admin Car", admin_car);
            registry.bind("Admin Account", admin_acc);
            registry.bind("Admin", admin);


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
