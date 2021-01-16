
package rmi;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import java.util.Date;

public class BankAccount implements Serializable {
    private String mail;
    private double balance;

    private int id;
    private int userID;

    private String CCnumber;
    private int ccv;
    private Date expDate;

    private ArrayList<BankAccount> bankAcc;
    private Account acc;

    public Account getAcc() {
        return acc;
    }

    public void setAcc(Account acc) {
        this.acc = acc;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

   /* public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
*/
    public String getCCnumber() {
        return CCnumber;
    }

    public void setCCnumber(String CCnumber) {
        this.CCnumber = CCnumber;
    }

    public int getCcv() {
        return ccv;
    }

    public void setCcv(int ccv) {
        this.ccv = ccv;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public void updateBalance(double amount, String email) throws RemoteException{
        DB db = new DB();
        Client client = new Client();
        BankAccount bAcc = new BankAccount();

        client = db.retrieveClientByMail2(email);
        bAcc = client.getBankAcc();
        if (checkAccountBalance(client, amount)) {
            double new_Balance = client.getBankAcc().getBalance() - amount;
            client.getBankAcc().setBalance(new_Balance);
            bAcc.setBalance(new_Balance);
            db.updateBalance(bAcc, client);

        } else {
            System.out.println("Transaction Incomplete! Not Enough Money!");
        }
    }

    public boolean checkAccountBalance(Client c, double amount) throws RemoteException {
        if(c.getBankAcc().getBalance() >= amount)   return true;
        else return false;
    }

    public boolean checkCCinfo(String ccNum, int ccv, String mail) throws RemoteException {
        DB db = new DB();
        Client client = new Client();
        BankAccount bAcc = new BankAccount();

        client = db.retrieveClientByMail2(mail);

        bAcc = client.getBankAcc();
        if(bAcc.getCCnumber().equals(ccNum) && bAcc.getCcv()==ccv)
            return true;
        else return false;
    }


    @Override
    public String toString(){
        String result =
                "\nBalance:" + getBalance()
                + "\nCredit Card Number: " + getCCnumber()
                + "\nCCV:" + getCcv()
                + "\nexpiration Date:" + getExpDate();
        return result;
    }
}
