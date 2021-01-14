package rmi;

import rmi.Interface.PayMethod;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OnlinePayment implements PayMethod {

    BankAccount bankAcc;

    @Override
    public void Pay(double amount){
        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter ccNum: ");
            String ccNum = sc.nextLine();
            sc.nextLine();
            System.out.println("Enter ccv: ");
            int ccv = sc.nextInt();
            System.out.println("Enter ExpDate: ");
            String expDate = sc.nextLine();
            Date date1 = new SimpleDateFormat("MM/yyyy").parse(expDate);

            if(bankAcc.checkCCinfo(ccNum, ccv, date1)){
                bankAcc.updateBalance(amount);
            }
            System.out.println("Payment Over");


        } catch (RemoteException ex) {
            Logger.getLogger(OnlinePayment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(OnlinePayment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
