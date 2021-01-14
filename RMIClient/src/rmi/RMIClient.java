package rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RMIClient {

    public static void main(String[] args) {

        try{
            Registry registry = LocateRegistry.getRegistry(1099);
            AccountInterface acc = (AccountInterface) registry.lookup("Account");
            ClientInterface client = (ClientInterface) registry.lookup("Client");

            String sDate1="12/2025";
            Date date1 = new SimpleDateFormat("MM/yyyy").parse(sDate1);

            acc.createClientAccount("Omar", "1346", "omar1346", "124679", AccType.CLIENT,
                    2500,"1234 2225 6987 1025",882,date1);

           // System.out.println(acc.viewAllAccounts());
            acc.login("omar1346","1346");
            System.out.println(acc.viewOwnAccount());
            client.editAccount();
            System.out.println(acc.viewOwnAccount());
          /*  acc.login("omar1346","1346");
            client.editAccount();
            acc.viewOwnAccount();*/

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
