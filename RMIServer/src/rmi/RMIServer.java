package rmi;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Filters;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;

public class RMIServer {

    public static void main(String[] args) {
        try {
            DB db = new DB();
            Account acc = new Account();

            Account omar = new Account(1, "Omar", "1346", "omar1346", "124679", AccType.CLIENT);
            Account tahseen = new Account(2, "Tahseen", "1346", "tahseen1346", "124679", AccType.DRIVER);
            Account hoda = new Account(3, "Hoda", "1346", "hoda1346", "124679", AccType.CLIENT);
            Account mai = new Account(4, "Mai", "1346", "Maia1346", "124679", AccType.CLIENT);

//            db.insertAccount(omar);
//            db.insertAccount(tahseen);
            db.insertAccount(hoda);
//            db.insertAccount(mai);
            //--------------Driver Initialization-------------------------//
//            AvailableTimes v1 = new AvailableTimes("Thursday");
//            AvailableTimes v2 = new AvailableTimes("Firday");
//            ArrayList<AvailableTimes> times = new ArrayList();
//            times.add(v1);
//            times.add(v2);
//            Car car1 = new Car("Toyota", "ABC123", "White");
//            Driver driver1 = new Driver(tahseen,CurrentArea.MADINTYSHEROUK,null,null, (float) 4.4,"135790",times,car1);
//            
//            //--------------Client Initialization-------------------------//
//            Client client1 = new Client(hoda,CurrentArea.NEWCAIRO,null,null, (float) 4.1);
//            
//            // acc.createClientAccount("asd","asd","asd","123",AccType.CLIENT);
//            for (int i = 0; i < db.retrieveAccounts().size(); i++) {
//                System.out.println(db.retrieveAccounts().get(i).toString());
//
//            }
//
//            Ride ride = new Ride();

            //acc.viewAccount("hoda1346");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}
