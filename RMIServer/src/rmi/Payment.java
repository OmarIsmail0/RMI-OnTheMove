
package rmi;

import rmi.Interface.PayMethod;

public class Payment {

    private int pID;
    private Client client;
    private int amount;
    private PayMethod method;

    public Payment(){

    }

    public Payment(PayMethod method){
        this.method = method;
    }

    public int getpID() {
        return pID;
    }

    public void setpID(int pID) {
        this.pID = pID;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void executeStrategy(double amount, BankAccount bankAcc){
        method.Pay(amount,bankAcc);
    }

}
