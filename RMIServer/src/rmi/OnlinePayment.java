package rmi;

import rmi.Interface.PayMethod;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OnlinePayment implements PayMethod , Serializable {

    BankAccount bankAcc;

    @Override
    public void Pay(double amount, BankAccount bankAcc){
        try {
            bankAcc.updateBalance(amount,bankAcc.getMail());
            System.out.println("Transaction Complete");
        } catch (RemoteException ex) {
            Logger.getLogger(OnlinePayment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
