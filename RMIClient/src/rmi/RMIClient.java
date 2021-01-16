package rmi;

import rmi.ReadOnly.*;
import rmi.Interface.ClientInterface;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class RMIClient {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            /*-----------------------------RMI----------------------------------*/
            Registry registry = LocateRegistry.getRegistry(1199);
            ClientReadOnly client_acc = (ClientReadOnly) registry.lookup("Client Account");
            ClientInterface client = (ClientInterface) registry.lookup("Client");
            ClientReadOnly client_ride = (ClientReadOnly) registry.lookup("Client Ride");
            ClientReadOnly client_comp = (ClientReadOnly) registry.lookup("Client Complaint");
            ClientReadOnly client_notify = (ClientReadOnly) registry.lookup("Client Notify");
            /*-----------------------------Creating client account----------------------------------*/
            String sDate1="12/2025";
            Date date1 = new SimpleDateFormat("MM/yyyy").parse(sDate1);
            client_acc.createClientAccount("Ahmed", "1346", "ahmed1134646", "124679", AccType.CLIENT,
                    2500,"1234 2225 6987 1025",882,date1);
            client_acc.createClientAccount("Omar", "1346", "omar1134646", "124679", AccType.CLIENT,
                    2500,"1234 2225 6987 1025",882,date1);

            /*-----------------------------Login & Request Ride & Show Ride History----------------------------------*/
            /*client_acc.login("ahmed1134646", "1346");
            client_ride.requestRide(CurrentArea.MAADI, CurrentArea.MADINTYSHEROUK,"ahmed1134646",true);
            System.out.println("-----------------------------------------------------------------------------------");
            client_ride.requestRide(CurrentArea.NEWCAIRO, CurrentArea.MAADI,"omar1134646",false);
            System.out.println("-----------------------------------------------------------------------------------");
            client_ride.viewRideHistory("ahmed1134646");
            System.out.println("-----------------------------------------------------------------------------------");
            client_ride.viewRideHistory("omar1134646");*/
            /*-----------------------------Edit Account----------------------------------*/
            /*client_acc.login("ahmed1134646", "1346");
            client.editAccount();
            System.out.println(client_acc.viewOwnAccount("ahmed1134646"));*/
            /*-----------------------------Give Complaint----------------------------------*/
            /*client_acc.login("ahmed1134646", "1346");
            client_ride.viewRideHistory("ahmed1134646");
            System.out.print("Select ride id: ");
            int id = input.nextInt();
            client_comp.giveComplaint("Ride was late!",id,"ahmed1134646");*/
            //The complaint will be added to the database
            /*-----------------------------View Ride History----------------------------------*/
            /*client_acc.login("ahmed1134646", "1346");
            client_ride.viewRideHistory("ahmed1134646");*/
            /*-----------------------------Shows that view & clear notiication works----------------------------------*/
            /*System.out.println(client_notify.viewNotifications("ahmed1134646"));
            client_notify.clearNotification("ahmed1134646");
            System.out.println(client_notify.viewNotifications("ahmed1134646"));*/

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex);
        }
        /*acc.createClientAccount("Omar", "1346", "omar1346", "124679", AccType.CLIENT,
                    2500,"1234 2225 6987 1025",882,date1);
           acc.createClientAccount("Ahmed", "1346", "ahmed1346", "124679", AccType.CLIENT,
                    2500,"1234 5555 5555 1025",882,date2);*/
    }

}
