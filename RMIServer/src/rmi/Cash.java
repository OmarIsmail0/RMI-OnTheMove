package rmi;

import rmi.Interface.PayMethod;


public class Cash implements PayMethod {

    @Override
    public void Pay(double amount, BankAccount bankAcc){
        System.out.println("Cash Payment Complete");
    }
}