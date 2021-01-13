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
import java.rmi.RemoteException;
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

        acc.setAccID(index+1);
        collection.insertOne(Document.parse(gson.toJson(acc)));
        System.out.println("Account inserted.");
    }
    public ArrayList<Account> retrieveAllAccounts() {
        collection = database.getCollection("Account");
        ArrayList<Account> result = new ArrayList();
        ArrayList<Document> docs = collection.find().into(new ArrayList<Document>());
        if(docs.isEmpty())
        {
            return result;
        }else{
            for (int i = 0; i < docs.size(); i++) {
                result.add(gson.fromJson(docs.get(i).toJson(), Account.class));
            }
        }
        return result;
    }
    public Account retrieveAccount(String email) {
        collection = database.getCollection("Account");
        Document doc = collection.find(Filters.eq("email", email)).first();
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

}
