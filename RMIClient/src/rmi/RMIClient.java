package rmi;

import rmi.ReadOnly.*;
import rmi.Interface.ClientInterface;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RMIClient {

    public static void main(String[] args) {

        try{
            Registry registry = LocateRegistry.getRegistry(1099);
            ClientReadOnly client_acc = (ClientReadOnly) registry.lookup("Client Account");
            ClientInterface client = (ClientInterface) registry.lookup("Client");
            ClientReadOnly client_ride = (ClientReadOnly) registry.lookup("Client Ride");
/*

            String sDate1="12/2025";
             Date date1 = new SimpleDateFormat("MM/yyyy").parse(sDate1);

            client_acc.createClientAccount("Omar", "1346", "ahmed134646", "124679", AccType.CLIENT,
                    2500,"1234 2225 6987 1025",882,date1);
*/

            //client_acc.login("ahmed134646","1346");
            client_ride.requestRide(CurrentArea.MAADI, CurrentArea.MADINTYSHEROUK,"ahmed134646",true);
            client_ride.requestRide(CurrentArea.MAADI, CurrentArea.NEWCAIRO,"ahmed134646",false);
            //System.out.println(acc.viewAllAccounts());
            //client.editAccount();
            //System.out.println(client_acc.viewOwnAccount());
            //client_ride.requestRide(CurrentArea.MAADI, CurrentArea.MADINTYSHEROUK);
            //client.editAccount();
            //System.out.println(client_acc.viewOwnAccount());
            //client_acc.login("omar1346","1346");
            //client.editAccount();
            //client_acc.viewOwnAccount();

        }catch (Exception ex){
            ex.printStackTrace();
            System.out.println(ex);
        }
        /*acc.createClientAccount("Omar", "1346", "omar1346", "124679", AccType.CLIENT,
                    2500,"1234 2225 6987 1025",882,date1);
           acc.createClientAccount("Ahmed", "1346", "ahmed1346", "124679", AccType.CLIENT,
                    2500,"1234 5555 5555 1025",882,date2);*/
    }
    
}
