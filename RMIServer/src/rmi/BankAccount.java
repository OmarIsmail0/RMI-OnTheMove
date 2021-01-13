
package rmi;

import java.util.ArrayList;
import java.util.Date;

import java.util.Date;

public class BankAccount {
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
    
    public void updateBalance(double x,int y){
        
    }
    public void checkAccountBalance(double x,int y){
        
    }
    public void checkCCinfo(int x, double y, Date date){
        
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
