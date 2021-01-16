package rmi.Interface;

import rmi.BankAccount;

public interface PayMethod {
    public void Pay(double amount, BankAccount bankAcc);
}
