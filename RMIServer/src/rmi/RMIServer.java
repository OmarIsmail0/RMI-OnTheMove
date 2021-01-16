package rmi;

public class RMIServer {

    public static void main(String[] args) {
<<<<<<< Updated upstream
        
=======
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

/*
            AccountInterface account = new Account();
            CarInterface car = new Car();
            ClientInterface client = new Client();
*/

            Registry registry = LocateRegistry.createRegistry(1080);

/*
            registry.bind("Account", account);
            registry.bind("Car", car);
            registry.bind("Client", client);
            */


            DB db = new DB();

            Account acc = new Account();
            Complaint comp = new Complaint();
            Ride ride = new Ride();

                    /*Client*/
            ClientReadOnly client_acc  = new Account();
            ClientInterface client = new Client();
            ClientReadOnly client_comp = new Complaint();
            ClientReadOnly client_ride = new Ride();


            registry.bind("Client Account", client_acc);
            registry.bind("Client", client);
            registry.bind("Client Complaint", client_comp);
            registry.bind("Client Ride", client_ride);

                    /*Driver*/
            DriverReadOnly driver_acc  = new Account();
            DriverReadOnly driver_comp = new Complaint();
            DriverReadOnly driver_ride = new Ride();
            DriverReadOnly driver_car = new Car();
            RequestRideInterface driver_select = new RequestRide();

            registry.bind("Driver Account", driver_acc);
            registry.bind("Driver Complaint", driver_comp);
            registry.bind("Driver Ride", driver_ride);
            registry.bind("Driver Car", driver_car);
            registry.bind("Select",driver_select);

                    /*Admin*/
            AdminReadOnly  admin_acc  = new Account();
            AdminInterface admin = new Admin();

            registry.bind("Admin Account", admin_acc);
            registry.bind("Admin", admin);


        } catch (Exception ex) {
            ex.printStackTrace();
        }
>>>>>>> Stashed changes
    }
    
}
