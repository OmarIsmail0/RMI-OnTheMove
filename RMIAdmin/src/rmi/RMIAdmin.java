package rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class RMIAdmin {

    public static void main(String[] args) {
        try{
            Registry registry = LocateRegistry.getRegistry(1099);
            AccountInterface acc = (AccountInterface) registry.lookup("Account");

            String sDate1="12/1998";
            Date date1 = new SimpleDateFormat("MM/yyyy").parse(sDate1);

            AvailableTimes v1 = new AvailableTimes("Thursday");
            AvailableTimes v2 = new AvailableTimes("Firday");
            ArrayList<AvailableTimes> times = new ArrayList();
            times.add(v1);
            times.add(v2);

            acc.createDriverAccount("ahmed", "1346", "ahmed1346", "124679", AccType.DRIVER,
                    "ABC123",times,882,CurrentArea.MAADI);

            acc.viewAllAccounts();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    
}
