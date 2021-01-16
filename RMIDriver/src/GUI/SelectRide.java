package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmi.DriverHome;
import rmi.Interface.RequestRideInterface;

public class SelectRide {
    DriverHome gui;
    Registry r;
    
    public SelectRide(DriverHome gui, Registry r)
        {
            this.gui = gui;
            this.r = r;
            gui.getButton1().addActionListener(new SelectRide.ViewRideBtnAction());
        }
    class ViewRideBtnAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                RequestRideInterface d = (RequestRideInterface) r.lookup("Select");
                String email = gui.getTextField1().getText();
                d.selectRide(email);
                //add in function body jpanel for output               
            } catch (Exception ex) {
                Logger.getLogger(SelectRide.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        
    }
}
