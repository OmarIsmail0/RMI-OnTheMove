package rmi;

import rmi.ReadOnly.ClientReadOnly;


import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;

public class Notification extends UnicastRemoteObject implements ClientReadOnly, Serializable {
    int id;
    String message;
    String client_email;

    public Notification(int id, String message, String email) throws RemoteException {
        this.id = id;
        this.message = message;
        this.client_email = email;
    }

    public Notification() throws RemoteException {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getClient_email() {
        return client_email;
    }

    public void setClient_email(String client_email) {
        this.client_email = client_email;
    }


    @Override
    public String viewNotifications(String email) throws RemoteException {
        DB db = new DB();
        ArrayList<Notification> n = new ArrayList<Notification>();
        String msg = " ";

        n = db.retrieveAllNotificationByMail(email);
        for (int i = 0; i < n.size(); i++) {
            msg += display(n.get(i));
            msg += "\n-------------------------------------------";
        }
        return msg;
    }

    @Override
    public void clearNotification(String email) throws RemoteException {
        DB db = new DB();
        ArrayList<Notification> n = new ArrayList<Notification>();
        n = db.retrieveAllNotificationByMail(email);
        for (int i = 0; i < n.size(); i++) {
            db.deleteNotification(n.get(i).getId());
        }
    }

    public String display(Notification n) {
        return "Notification ID: " + n.getId()
                + ", Message: '" + n.getMessage();
    }


    @Override
    public void createClientAccount(String username, String password, String email, String mobile, AccType type, double balance, String CCnumber, int ccv, Date expDate) throws RemoteException {

    }

    @Override
    public String viewOwnAccount(String email) throws RemoteException {
        return null;
    }

    @Override
    public boolean login(String email, String password) throws RemoteException {
        return false;
    }

    @Override
    public void requestRide(CurrentArea PUL, CurrentArea DST, String email, boolean payOnline) throws RemoteException {

    }


    @Override
    public ArrayList<RequestRide> viewRideHistory(String email) throws RemoteException {
        return null;
    }

    @Override
    public void giveComplaint(String msg, int rideID, String email) throws RemoteException {

    }

    @Override
    public void editAccount() throws RemoteException {

    }
}
