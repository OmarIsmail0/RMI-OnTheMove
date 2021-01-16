package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

import rmi.DriverHome;
import rmi.LoginWindowDriver;
import rmi.ReadOnly.DriverReadOnly;

import javax.swing.*;

public class DriverLogin {
    LoginWindowDriver gui;
    DriverHome driverHome = new DriverHome();
    Registry r;
    
    public DriverLogin(LoginWindowDriver gui, Registry r)
        {
            this.gui = gui;
            this.r = r;
            gui.getjButton1().addActionListener(new DriverLogin.LoginBtnAction());
        }    
    class LoginBtnAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                DriverReadOnly driver_acc = (DriverReadOnly) r.lookup("Driver Account");
                boolean check = false;
                String email = gui.getjTextField1().getText();
                String pass = gui.getjTextField().getText();
                check = driver_acc.login(email, pass); // in login function mainbody make the login action switch to the client home GUI
                if (check) {
                    gui.setVisible(false);
                    driverHome.setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(gui,"try again!");
                }
                               
            } catch (Exception ex) {
                Logger.getLogger(DriverLogin.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        
    }
}
