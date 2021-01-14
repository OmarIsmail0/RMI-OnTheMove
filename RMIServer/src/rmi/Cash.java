package rmi;

import rmi.Interface.PayMethod;


public class Cash implements PayMethod {

    @Override
    public void Pay(double amount){
        System.out.println("Payment Over");
    }
}