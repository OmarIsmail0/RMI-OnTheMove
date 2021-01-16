
package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.registry.Registry;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import rmi.HomeWindowGUI;

import rmi.AccType;
import rmi.ReadOnly.ClientReadOnly;

public class HomeWindow {
    HomeWindowGUI gui;
    Registry r;
    
    public HomeWindow(HomeWindowGUI gui, Registry r)
        {
            this.gui = gui;
            this.r = r;
            gui.getjButton1().addActionListener(new CreateAccountBtnAction());          
        }
    class CreateAccountBtnAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                ClientReadOnly c = (ClientReadOnly) r.lookup("client_acc");
                String username = gui.getjTextField1().getText();
                String email = gui.getjTextField2().getText();
                String pass = gui.getjTextField5().getText();
                String mobile = gui.getjTextField4().getText();
                String type = gui.getjTextField3().getText(); 
                AccType accType = AccType.valueOf(type); 
                double balance = Double.parseDouble(gui.getjTextField6().getText());
                int ccv = Integer.parseInt(gui.getjTextField8().getText()); 
                String cardNum = gui.getjTextField7().getText();
                String expDate = gui.getjTextField9().getText(); 
                Date date = new SimpleDateFormat("MM/yyyy").parse(expDate);
                c.createClientAccount(username, pass, email, mobile, accType, balance, cardNum, ccv, date);

                gui.getjLabel10().setText("Creating Account");
                //in create account function body make it go to the client home GUI 
               
            } catch (Exception ex) {
                Logger.getLogger(HomeWindow.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        
    }
    
}
