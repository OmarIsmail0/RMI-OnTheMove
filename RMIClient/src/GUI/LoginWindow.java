package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

import rmi.*;

import javax.swing.*;

import rmi.LoginWindowGUI;
import rmi.ReadOnly.ClientReadOnly;

public class LoginWindow {
    static String loginMail;
    LoginWindowGUI gui;
    ClientHomeGUI clientGUI = new ClientHomeGUI();
    Registry r;

    public LoginWindow(LoginWindowGUI gui, Registry r) {
        this.gui = gui;
        this.r = r;
        gui.getjButton1().addActionListener(new LoginWindow.LoginBtnAction());
    }

    class LoginBtnAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                boolean check = false;
                ClientReadOnly c = (ClientReadOnly) r.lookup("Client Account");
                String email = gui.getjTextField1().getText();
                String pass = gui.getjTextField().getText();
                check = c.login(email, pass); // in login function mainbody make the login action switch to the client home GUI
                if (check) {
                    loginMail = email;
                    gui.setVisible(false);
                    ClientHome home = new ClientHome(clientGUI, r);
                    clientGUI.setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(gui,"try again!");
                }

            } catch (Exception ex) {
                Logger.getLogger(LoginWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
