package rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {

    public static void main(String[] args) {
        try {
            AccountInterface acc = new Account();
            AdminInterface admin = new Admin();

            Registry registry = LocateRegistry.createRegistry(1099);

            registry.bind("Create Client Account", acc);
            registry.bind("Admin", admin);

        }catch (Exception ex){
            System.out.println("Exception occurred");
        }
    }
    
}
