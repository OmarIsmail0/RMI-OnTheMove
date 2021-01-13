package rmi;


import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class RMIServer {

    public static void main(String[] args) {
        try {
      /*      DB db = new DB();
            Account acc = new Account();

            Account omar = new Account(1, "Omar", "1346", "omar1346", "124679", AccType.CLIENT);
            Account tahseen = new Account(2, "Tahseen", "1346", "tahseen1346", "124679", AccType.CLIENT);
            Account hoda = new Account(3, "Hoda", "1346", "hoda1346", "124679", AccType.CLIENT);
            Account mai = new Account(4, "Mai", "1346", "Maia1346", "124679", AccType.CLIENT);

          db.insertAccount(omar);
            db.insertAccount(tahseen);
            db.insertAccount(hoda);
            db.insertAccount(mai);
            
            
           // acc.createClientAccount("asd","asd","asd","123",AccType.CLIENT);
            for (int i = 0; i < db.retrieveAccounts().size(); i++) {
                System.out.println(db.retrieveAccounts().get(i).toString());
            }
            String sDate1="12/1998";
            Date date1 = new SimpleDateFormat("MM/yyyy").parse(sDate1);

            String sDate2="5/2024";
            Date date2 = new SimpleDateFormat("MM/yyyy").parse(sDate1);

           acc.createClientAccount("Omar", "1346", "omar1346", "124679", AccType.CLIENT,
                    2500,"1234 2225 6987 1025",882,date1);
           acc.createClientAccount("Ahmed", "1346", "ahmed1346", "124679", AccType.CLIENT,
                    2500,"1234 5555 5555 1025",882,date2);

           //acc.viewAllAccounts();
           acc.banAccount("omar1346");
           acc.viewAllAccounts();*/

            AccountInterface account = new Account();
            Registry registry = LocateRegistry.createRegistry(1099);

            registry.bind("Account", account);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
