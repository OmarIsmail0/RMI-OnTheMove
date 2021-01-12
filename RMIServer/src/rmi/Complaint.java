/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

/**
 *
 * @author Laptop Shop
 */
public class Complaint {
    private int cmpID;
    private Account acc;
    private String msg;
    private Ride ride;

    public int getCmpID() {
        return cmpID;
    }

    public void setCmpID(int cmpID) {
        this.cmpID = cmpID;
    }

    public Account getAcc() {
        return acc;
    }

    public void setAcc(Account acc) {
        this.acc = acc;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Ride getRide() {
        return ride;
    }

    public void setRide(Ride ride) {
        this.ride = ride;
    }
    
    public void giveComplaint(Account acc ,String str){
        
    }
}
