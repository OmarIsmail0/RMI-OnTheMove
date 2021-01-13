/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.util.*;


import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
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
        db = new MongoClient();
        database = db.getDatabase("OnTheMove"); // Database name
        collection = database.getCollection("Account"); // Collection name
    }

    public void insertStudent(Account s) {
        collection.insertOne(Document.parse(gson.toJson(s)));
        System.out.println("Account inserted.");
    }

    public ArrayList<Account> getAllStudents() {
        ArrayList<Account> result = new ArrayList();
        ArrayList<Document> docs = collection.find().into(new ArrayList<Document>());
        for (int i = 0; i < docs.size(); i++) {
            result.add(gson.fromJson(docs.get(i).toJson(), Account.class));
        }
        return result;
    }
}
