/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.RemoteException;
import java.util.*;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;

public class DB {

    private MongoClient db;
    private MongoDatabase database;
    private MongoCollection<Document> collection;
    private Gson gson = new Gson();

    public DB() {
        // Disables Mongo Logs
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);

        // Initialize
        String connectionString = "mongodb+srv://AOOPSE:123@cluster0.g6utq.mongodb.net/<dbname>?retryWrites=true&w=majority";
        db = new MongoClient(new MongoClientURI(connectionString));
        database = db.getDatabase("OnTheMove"); // Database name

    }

    /*-----------------Account-----------------*/
    public void insertAccount(Account acc) {
        collection = database.getCollection("Account");
        ArrayList<Account> result = new ArrayList();
        result = retrieveAllAccounts();
        int index = 0;
        for (int i = 0; i < result.size(); i++) {
            index = result.get(i).getAccID();
        }
        acc.setAccID(index + 1);
        collection.insertOne(Document.parse(gson.toJson(acc)));
        System.out.println("Account inserted.");
    }

    public ArrayList<Account> retrieveAllAccounts() {
        collection = database.getCollection("Account");
        ArrayList<Account> result = new ArrayList();
        ArrayList<Document> docs = collection.find().into(new ArrayList<Document>());
        if (docs.isEmpty()) {
            return result;
        } else {
            for (int i = 0; i < docs.size(); i++) {
                result.add(gson.fromJson(docs.get(i).toJson(), Account.class));
            }
        }
        return result;
    }

    public Account retrieveAccount(int id) {
        collection = database.getCollection("Account");
        Document doc = collection.find(Filters.eq("accID", id)).first();
        Account result = gson.fromJson(doc.toJson(), Account.class);
        return result;
    }

    public void deleteAccount(String email) {
        collection = database.getCollection("Account");
        collection.deleteOne(Filters.eq("email", email));
    }

    /*-----------------Bank-----------------*/
    public void insertBankAccount(BankAccount bankAcc) {
        collection = database.getCollection("BankAccount");
        collection.insertOne(Document.parse(gson.toJson(bankAcc)));

    }

    public ArrayList<BankAccount> retrieveAllBankAccounts() {
        collection = database.getCollection("BankAccount");
        ArrayList<BankAccount> result = new ArrayList();
        ArrayList<Document> docs = collection.find().into(new ArrayList<Document>());
        for (int i = 0; i < docs.size(); i++) {
            result.add(gson.fromJson(docs.get(i).toJson(), BankAccount.class));
        }
        return result;
    }

    public void deleteBankAccount(String email) {
        collection = database.getCollection("BankAccount");
        collection.deleteOne(Filters.eq("mail", email));
    }

    public void updateBalance(BankAccount acc, double balance, int userID) {
        collection = database.getCollection("BankAccount");
        collection.updateOne(Filters.eq("balance", acc.getBalance()), Updates.set("balance", balance));
    }

    public double checkAccountBalance(int userID) {
        collection = database.getCollection("BankAccount");
        Document doc = collection.find(Filters.eq("userID", userID)).first();
        BankAccount acc = gson.fromJson(doc.toJson(), BankAccount.class);
        return acc.getBalance();
    }

    public BankAccount checkCCinfo(String CCNumber) {
        collection = database.getCollection("BankAccount");
        Document doc = collection.find(Filters.eq("CCnumber", CCNumber)).first();
        BankAccount acc = gson.fromJson(doc.toJson(), BankAccount.class);
        return acc;
    }

    /*-----------------Client-----------------*/
    public void insertClient(Client client) {
        collection = database.getCollection("Client");
        collection.insertOne(Document.parse(gson.toJson(client)));

    }

    public ArrayList<Client> retrieveAllClients() {
        collection = database.getCollection("Client");
        ArrayList<Client> result = new ArrayList();
        ArrayList<Document> docs = collection.find().into(new ArrayList<Document>());
        for (int i = 0; i < docs.size(); i++) {
            result.add(gson.fromJson(docs.get(i).toJson(), Client.class));
        }
        return result;
    }

    public void deleteClient(String email) {
        collection = database.getCollection("Client");
        collection.deleteOne(Filters.eq("acc.email", email));
    }

    /*-----------------Driver-----------------*/
    public void insertDriver(Driver driver) {
        collection = database.getCollection("Driver");
        collection.insertOne(Document.parse(gson.toJson(driver)));

    }

    public ArrayList<Driver> retrieveAllDrivers() {
        collection = database.getCollection("Driver");
        ArrayList<Driver> result = new ArrayList();
        ArrayList<Document> docs = collection.find().into(new ArrayList<Document>());
        for (int i = 0; i < docs.size(); i++) {
            result.add(gson.fromJson(docs.get(i).toJson(), Driver.class));
        }
        return result;
    }

    public Driver retrieveDriverByMail(String mail) {
        collection = database.getCollection("Driver");
        Document doc = collection.find(Filters.eq("acc.email", mail)).first();
        Driver result = gson.fromJson(doc.toJson(), Driver.class);
        return result;
    }
    
    public void deleteDriver(String email) {
        collection = database.getCollection("Driver");
        collection.deleteOne(Filters.eq("acc.email", email));
    }
    
    public void updateDriver(Driver driver) {
        collection = database.getCollection("Driver");
        Document doc = Document.parse(gson.toJson(driver));
        collection.replaceOne(Filters.eq("acc.email", driver.getAcc().getEmail()), doc);
    }

    /*-----------------Ride-----------------*/
    public void createRide(Ride ride) {
        collection = database.getCollection("Ride");
        collection.insertOne(Document.parse(gson.toJson(ride)));
    }

    public void insertComplaint(Complaint comp) {
        collection = database.getCollection("Complaint");
        collection.insertOne(Document.parse(gson.toJson(comp)));
    }

    public Ride retrieveRide(int id) {
        collection = database.getCollection("Ride");
        Document doc = collection.find(Filters.eq("id", id)).first();
        Ride result = gson.fromJson(doc.toJson(), Ride.class);
        return result;
    }

}
