package rmi;

import rmi.Interface.AdminInterface;
import rmi.ReadOnly.AdminReadOnly;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Scanner;


public class Admin extends UnicastRemoteObject implements AdminInterface, Serializable {

    static Admin adminInstance;
    Account acc;
//  User user;

    private AdminReadOnly ARO;

    Admin(AdminReadOnly ARO) throws RemoteException{
        this.ARO = ARO;
    }

    Admin() throws RemoteException {

    }

    /*public Admin adminInstance() throws RemoteException{
        return adminInstance;

    }*/

    public static Admin getInstance() throws RemoteException{
        if(adminInstance == null)
            adminInstance = new Admin();
        return adminInstance;
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
            if (acc.get(i).getEmail().equals(Account.Driver_Login_Mail)) {
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

    public void createDriverAccount(String username, String password, String email, String mobile, AccType type, String driverLicense, ArrayList<AvailableTimes> workingTimes, String carModel, String plateNum, String carColor, float rating, CurrentArea currentArea) throws RemoteException {
        ARO.createDriverAccount(username,password,email,mobile,type,driverLicense,workingTimes,carModel,plateNum,carColor,rating,currentArea);
    }
    public String viewAllAccounts() throws RemoteException {
        return ARO.viewAllAccounts();
    }
    public boolean login(String email, String password) throws RemoteException {
        return ARO.login(email, password);
    }
    public void banAccount(String email) throws RemoteException {
        ARO.banAccount(email);
    }



}
