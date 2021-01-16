package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmi.LoginWindowGUI;
import javax.swing.JButton;
import rmi.AccType;
import rmi.LoginWindowGUI;
import rmi.HomeWindowGUI;
import rmi.ReadOnly.ClientReadOnly;

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
                c.login(email, pass); // in login function mainbody make the login action switch to the client home GUI
                               
            } catch (Exception ex) {
                Logger.getLogger(LoginWindow.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        
    }

}
