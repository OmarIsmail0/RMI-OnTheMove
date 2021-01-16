package rmi;

import GUI.AdminHome;
import rmi.Interface.*;
import rmi.ReadOnly.*;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class RMIAdmin {

    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);

            Registry registry = LocateRegistry.getRegistry(1500);

            AdminReadOnly admin_acc = (AdminReadOnly) registry.lookup("Admin Account");
            AdminReadOnly admin_car = (AdminReadOnly) registry.lookup("Admin Car");
            AdminInterface admin = (AdminInterface) registry.lookup("Admin");


            /*-----------------------------Creating Driver Account----------------------------------*/
            /*AvailableTimes v1 = new AvailableTimes("Thursday");
            AvailableTimes v2 = new AvailableTimes("Friday");
            ArrayList<AvailableTimes> x = new ArrayList<>();
            x.add(v1);
            x.add(v2);
            String carColor = "blue";
            String carModel = "Toyota";
            String plateNum = "123ABC";
            admin_acc.createDriverAccount("islam", "1346", "islam1134646", "124679", AccType.DRIVER,
                    "ABC123", x, carModel, plateNum, carColor, (float) 0.0, CurrentArea.MAADI);
            System.out.println("Account Registered");*/
            //Check correctness in mongo db


            /*-----------------------------Update Driver Car----------------------------------*/
            /*String carColorX = "white";
            String carModelX = "hyundai";
            String plateNumX = "123DEF";
            String mail = "islam1134646";
            admin_car.updateCar(mail, carModelX, plateNumX, carColorX);*/
            //Check correctness in mongo db


            /*-----------------------------Ban Account----------------------------------*/
            System.out.println(admin_acc.viewAllAccounts());
            /*System.out.println("Enter Email");
            String email = input.nextLine();
            admin_acc.banAccount(email);*/
            //Check correctness in mongo db

            /*--------------------------------GUI ----------------------------------------*/
            AdminHomeGUI gui = new AdminHomeGUI();
            gui.setLocationRelativeTo(null); // This makes the window appears centered
            gui.setVisible(true); // This shows the gui

            AdminHome gui_controller = new AdminHome(gui, registry);

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex);
        }
    }

}
