
package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmi.AccType;
import rmi.AdminHomeGUI;
import rmi.AvailableTimes;
import rmi.CurrentArea;
import rmi.ReadOnly.AdminReadOnly;


public class AdminHome {
    AdminHomeGUI gui;
    Registry r;
    public AdminHome(AdminHomeGUI gui, Registry r)
        {
            this.gui = gui;
            this.r = r;
            gui.getjButton1().addActionListener(new AdminHome.createAccBtnAction());    
            gui.getjButton2().addActionListener(new AdminHome.banAccountBtnAction());

        }
        class createAccBtnAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                CurrentArea l = null;
                AdminReadOnly ad = (AdminReadOnly) r.lookup("Admin Account");
                String loc = (String)gui.getCombo().getSelectedItem();
                if (null != loc)switch (loc) {
                    case "Maadi":
                        l = CurrentArea.MAADI;
                        break;
                    case "MadintySherouk":
                        l = CurrentArea.MADINTYSHEROUK;
                        break;
                    case "Nasr City":
                        l = CurrentArea.NASRCITY;
                        break;
                    case "Zamalek":
                        l = CurrentArea.ZAMALEK;
                        break;
                    case "New Cairo":
                        l = CurrentArea.NEWCAIRO;
                        break;
                    default:
                        break;
                }; 
                String name = gui.getjTextField1().getText();
                String pw = gui.getjTextField2().getText(); 
                String email = gui.getjTextField3().getText(); 
                String phone = gui.getjTextField4().getText(); 
                String lisence = gui.getjTextField6().getText(); 
                String AvTimes = (String)gui.getCombo2().getSelectedItem();
                AvailableTimes v1 = new AvailableTimes("AvTimes");
                ArrayList<AvailableTimes> x = new ArrayList<>();
                x.add(v1);
                String model = gui.getjTextField8().getText(); 
                String plate = gui.getjTextField9().getText(); 
                String color = gui.getjTextField10().getText(); 
                String rating =gui.getjTextField11().getText(); 
                float rting = Float.parseFloat(rating);
                ad.createDriverAccount(name, pw, email, phone, AccType.DRIVER, lisence, x, model, plate, color, rting, l);
       
                               
            } catch (Exception ex) {
                Logger.getLogger(AdminHome.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }      
    }
        class banAccountBtnAction implements ActionListener{
             @Override
        public void actionPerformed(ActionEvent ae){
            try {
                AdminReadOnly ad = (AdminReadOnly) r.lookup("Admin Account");
                String email = gui.getjTextField7().getText();
                ad.banAccount(email);
                //make pop message in banaccount function body that complaint is done 
            } catch (Exception ex) {
                Logger.getLogger(AdminHome.class.getName()).log(Level.SEVERE, null, ex);
            }         
        }
    }
}
