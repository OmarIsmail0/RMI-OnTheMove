package rmi;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;


public class Account extends UnicastRemoteObject implements AccountInterface, Serializable {
    int accID;
    String username, password, email, mobile;
    AccType type;
    public ArrayList<Account> acc;
    public static int verificationCode;

    /*Login Info*/
    static int Login_ID;
    static AccType acc_type;

    public Account() throws RemoteException{

    }

    public Account(int accID, String username, String password, String email, String mobile, AccType type) throws RemoteException {
        this.accID = accID;
        this.username = username;
        this.password = password;
        this.email = email;
        this.mobile = mobile;
        this.type = type;
    }

    public Account(int accID, String username, String password, String email, String mobile, AccType type, ArrayList<Account> acc) throws RemoteException {
        this.accID = accID;
        this.username = username;
        this.password = password;
        this.email = email;
        this.mobile = mobile;
        this.type = type;
        this.acc = acc;
    }

    public int getAccID() {
        return accID;
    }

    public void setAccID(int accID) {
        this.accID = accID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public AccType getType() {
        return type;
    }

    public void setType(AccType type) {
        this.type = type;
    }

    public ArrayList<Account> getAcc() {
        return acc;
    }

    public void setAcc(ArrayList<Account> acc) {
        this.acc = acc;
    }

    public static int getVerificationCode() {
        return verificationCode;
    }

    public static void setVerificationCode(int verificationCode) {
        Account.verificationCode = verificationCode;
    }

    @Override
    public void createClientAccount(String username,String password,String email,String mobile,AccType type) throws RemoteException {
        Account new_Account = new Account();

        DB db = new DB();

        acc = db.retrieveAccounts();

        Scanner input = new Scanner(System.in);

        boolean unique = false;

        int numOfAttempts = 3;
        int code = 0;

        try {
            if (true/*type == AccType.CLIENT*/) {
                if (!acc.isEmpty()) {
                    for (int i = 0; i < acc.size(); i++) {
                        if (acc.get(i).getEmail().equals(email)) {
                            unique = false;
                            break;
                        } else {
                            unique = true;
                        }
                    }
                    if (unique) {
                        new_Account.setUsername(username);
                        new_Account.setPassword(password);
                        new_Account.setEmail(email);
                        new_Account.setMobile(mobile);
                        new_Account.setType(type);

                        /*new_BanAcc.setMail(loginMail);
                        new_BanAcc.setBalance(balance);
*/
                        sendVerification();
                        System.out.print("Enter your verification code: ");
                        while (numOfAttempts > 0) {
                            code = input.nextInt();
                            if (true) {
                                acc.add(new_Account);
                                //banAcc.add(new_BanAcc);
                                db.insertAccount(new_Account);
                                //db.insertNewBankAccount(acc, banAcc);
                                break;
                            } else {
                                numOfAttempts--;
                                System.out.println("please try again!");
                            }
                        }
                    } else if (!unique) {
                        System.err.println("this email is already registered");
                    }
                } else if (acc.isEmpty()) {

                    new_Account.setUsername(username);
                    new_Account.setPassword(password);
                    new_Account.setEmail(email);
                    new_Account.setMobile(mobile);
                    new_Account.setType(type);

                /*new_BanAcc.setMail(loginMail);
                new_BanAcc.setBalance(balance);*/

                    sendVerification();
                    System.out.print("Enter your verification code: ");
                    while (numOfAttempts > 0) {
                        code = input.nextInt();
                        if (true) {
                            acc.add(new_Account);
                            //banAcc.add(new_BanAcc);
                            db.insertAccount(new_Account);
                            //db.insertNewBankAccount(acc, banAcc);
                            break;

                        } else {
                            numOfAttempts--;
                            System.out.println("pls try again!");
                        }
                    }
                }
            }

        }catch (Exception ex){

        }
    }

    @Override
    public void createDriverAccount(String username,String password,String email,String mobile, AccType type) throws RemoteException{

    }

    @Override
    public void viewAccount(String email) throws RemoteException{
        Account account = new Account();
        DB db = new DB();
        account = db.retrieveAccount(email);
        System.out.println(account.toString());
    }
    @Override
    public boolean login(String EMAIL, String PW) throws RemoteException{
        DB db = new DB();
        acc = db.retrieveAccounts();
        int index = -1;

        for (int i = 0; i < acc.size(); i++) {
            if (acc.get(i).getEmail().equals(EMAIL)) {
                index = i;
            }
        }
        if (index == -1) {
            System.out.println("Incorrect Email");
        } else {
            if (acc.get(index).getPassword().equals(PW)) {
                Login_ID = acc.get(index).getAccID();
                acc_type = acc.get(index).getType();
                return true;
            } else {
                System.out.println("Incorrect Password");
                return false;
            }
        }
        return false;
    }
    @Override
    public void banAccount(String email) throws RemoteException{
        DB db = new DB();
        acc = db.retrieveAccounts();
        int index = -1;
        for (int i = 0; i < acc.size(); i++) {
            if (acc.get(i).getEmail().equals(email)) {
                index = i;
            }
        }
        if (index == -1) {
            System.out.println("account not found");
        } else {
            db.deleteAccount(acc.get(index).getEmail());
        }
    }
    @Override
    public void sendVerification() throws RemoteException{
        Random rand = new Random();
        String id = String.format("%04d", rand.nextInt(10000));
        verificationCode = Integer.parseInt(id);
        System.out.println("your verification code is: " + verificationCode);
    }
    @Override
    public boolean enterVerificationCode(int code) throws RemoteException{
        if (verificationCode == code) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public void approveChanges() throws RemoteException{

    }
    /*int accID, String username, String password, String email, String mobile, AccType type*/
    @Override
    public String toString() {
        String result = "Account ID: " + accID
                + "\nName: " + username
                + "\nEmail: " + email
                + "\nYear: " + mobile
                + "\nType: " + type
                + "\n------------------------";
        return result;

    }
}
