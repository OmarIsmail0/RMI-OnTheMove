package rmi;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
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
            Account tahseen = new Account(2, "Tahseen", "1346", "tahseen1346", "124679", AccType.CLIENT);
            Account hoda = new Account(3, "Hoda", "1346", "hoda1346", "124679", AccType.CLIENT);
            Account mai = new Account(4, "Mai", "1346", "Maia1346", "124679", AccType.CLIENT);

/*
            db.insertStudent(omar);
            db.insertStudent(tahseen);
            db.insertStudent(hoda);
            db.insertStudent(mai);
*/
            acc.createClientAccount("asd","asd","asd","123",AccType.CLIENT);
            for (int i = 0; i < db.getAllStudents().size(); i++) {
                System.out.println(db.getAllStudents().get(i).toString());
            }

        } catch (Exception ex) {
            System.out.println("Exception occurred");
        }
    }

}
