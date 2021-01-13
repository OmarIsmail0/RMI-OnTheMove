
package rmi;

public class Payment {
    
    private int pID;
    private Client client;
    private int amount;
    //private PayMethod method;

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

//    public PayMethod getMethod() {
//        return method;
//    }
//
//    public void setMethod(PayMethod method) {
//        this.method = method;
//    }

    
    
}
