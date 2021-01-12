package rmi;


import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
//import com.mongodb.client.model.Updates;
//import com.sun.istack.internal.logging.Logger;
import java.util.List;
import org.bson.Document;


public class RMIDatabase {

    
    public static void main(String[] args) {
        
        MongoClient client = new MongoClient();
            
        List <String> DBs = client.getDatabaseNames(); //retrieve all Databases from MongoServer
        System.out.print(DBs);
        
        MongoDatabase ICS = client.getDatabase("OnTheMove"); //to create our database that called "BUE"
        ICS.createCollection("User"); //create the collection that called "Students"
        MongoCollection User = ICS.getCollection("User"); //create obj. to access the created collection
        
        //Documents to insert them in the ICS database
        Document Doc1 = new Document ("Fname", "Abeer").append("Lname","Hamdy").append("Title", "Dr").append("Office", "Building G");
        Document Doc2 = new Document ("Fname", "Maher").append("Lname","Fayez").append("Title", "TA");
        Document Doc3 = new Document ("Fname", "Israa").append("Lname","Lotfy").append("Title", "TA");
        
        //CRUD Operations
        // **** 1- Create ****       
        User.insertOne(Doc1); // "insertOne" function uses to insert one document in the collection 
        User.insertOne(Doc2);
        User.insertOne(Doc3);
        
        // **** 2- Read ****
         Document Result = (Document)User.find(Filters.all("Title","Dr")).first();
         System.out.println(Result);

        // **** 3- Update ****
         //User.updateOne(Filters.eq("Title","Dr"),Updates.set("Title", "Prof."));
  
        // **** 4- Delete ****
         //User.deleteOne(Filters.eq("Title","TA"));      
        
        

        
        
    }
    
}
