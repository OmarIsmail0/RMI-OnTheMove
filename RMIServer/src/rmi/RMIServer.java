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

            Account omar = new Account(5, "Omar", "1346", "omar1346", "124679", AccType.CLIENT, null);
            db.insertStudent(omar);
            for (int i = 0; i < db.getAllStudents().size(); i++) {
                System.out.println(i);
                System.out.println(db.getAllStudents().get(i).toString());
            }

        } catch (Exception ex) {
            System.out.println("Exception occurred");
        }
    }

}
