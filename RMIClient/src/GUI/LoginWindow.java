/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.registry.Registry;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import rmi.AccType;
import rmi.LoginWindowGUI;
import rmi.HomeWindowGUI;
import rmi.ReadOnly.ClientReadOnly;

/**
 *
 * @author USCS
 */
public class LoginWindow {
        LoginWindowGUI gui;
    Registry r;
    
    public LoginWindow(LoginWindowGUI gui, Registry r)
        {
            this.gui = gui;
            this.r = r;
            gui.getjButton1().addActionListener(new LoginWindow.LoginBtnAction());
        }
    class LoginBtnAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                ClientReadOnly c = (ClientReadOnly) r.lookup("client_acc");
                String email = gui.getjTextField1().getText();
                String pass = gui.getjTextField().getText();
                c.login(email, pass);
                               
            } catch (Exception ex) {
                Logger.getLogger(HomeWindow.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        
    }

}
