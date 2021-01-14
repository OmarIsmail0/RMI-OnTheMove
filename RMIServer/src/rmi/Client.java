package rmi;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;

public class Client extends User implements ClientInterface, Serializable {
    int numOfRides;
    Ride ride;
    Notification notification;
    BankAccount bankAcc;

    //Constructor

    public Client() throws RemoteException{

    }

    public Client(Account acc, ArrayList<Ride> rides, float rating) throws RemoteException{
        super(acc, rides, rating);
        this.numOfRides=0;
    }
    
    //Setter And Getters
    public int getNumOfRides() {
        return numOfRides;
    }
    public void setNumOfRides(int numOfRides) {
        this.numOfRides = numOfRides;
    }
    public Ride getRide() {
        return ride;
    }
    public void setRide(Ride ride) {
        this.ride = ride;
    }
    public Notification getNotification() {
        return notification;
    }
    public void setNotification(Notification notification) {
        this.notification = notification;
    }
    public BankAccount getBankAcc() {
        return bankAcc;
    }
    public void setBankAcc(BankAccount bankAcc) {
        this.bankAcc = bankAcc;
    }

    @Override
    public void editAccount() throws RemoteException {
        Scanner input = new Scanner(System.in);
        DB db = new DB();
        ArrayList<Account> acc = db.retrieveAllAccounts();

        int choose = -1;
        int index = -1;
        String newRecord = "";
        for (int i = 0; i < acc.size(); i++) {
            if (acc.get(i).getEmail().equals(Account.Login_Mail)) {
                index = i;
            }
        }
        int choice = 0;

        if (index == -1) {
            System.out.println("not found");
        } else {
            System.out.println("enter 1 to change name or 2 to change password");
            System.out.println("Name: " + acc.get(index).getUsername());
            System.out.println("Password: " + acc.get(index).getPassword());

            choose = input.nextInt();
            if (choose == 1) {
                input.nextLine();
                System.out.println("Enter new name");
                newRecord = input.nextLine();
                choice = choose;
                acc.get(index).setUsername(newRecord);
            } else if (choose == 2) {
                input.nextLine();
                System.out.println("Enter new password");
                newRecord = input.nextLine();
                choice = choose;
                acc.get(index).setPassword(newRecord);
            }
            db.updateClient(acc.get(index));
        }

    }

}
