package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import rmi.ReadOnly.*;
import rmi.ClientHomeGUI;
import rmi.CurrentArea;
import rmi.ReadOnly.ClientReadOnly;
import rmi.NotificationHome;

public class ClientHome {
    ClientHomeGUI gui;
    NotificationHome notfgui;
    Registry r;
    
    public ClientHome(ClientHomeGUI gui, Registry r)
        {
            this.gui = gui;
            this.r = r;
            gui.getjButton1().addActionListener(new ClientHome.RequestBtnAction());    
            gui.getjButton2().addActionListener(new ClientHome.ViewRideBtnAction());
            gui.getjButton3().addActionListener(new ClientHome.ComplaintBtnAction());
            gui.getjButton4().addActionListener(new ClientHome.viewAccBtnAction());
            gui.getjButton5().addActionListener(new ClientHome.viewNotifBtnAction());
        }
    class RequestBtnAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                CurrentArea l = null; 
                CurrentArea d = null;
                ClientReadOnly c = (ClientReadOnly) r.lookup("client_acc");
                String loc = (String)gui.getCombo().getSelectedItem();
                if (null != loc)switch (loc) {
                    case "Maadi":
                        l = CurrentArea.MAADI;
                        break;
                    case "MadintySherouk":
                        l = CurrentArea.MADINTYSHEROUK;
                        break;
                    case "Nasrcity":
                        l = CurrentArea.NASRCITY;
                        break;
                    case "Zamalek":
                        l = CurrentArea.ZAMALEK;
                        break;
                    case "New cairo":
                        l = CurrentArea.NEWCAIRO;
                        break;
                    default:
                        break;
                }
;
                String dest = (String)gui.getCombo2().getSelectedItem();
                if (null != dest)switch (dest) {
                    case "Maadi":
                        d = CurrentArea.MAADI;
                        break;
                    case "MadintySherouk":
                        d= CurrentArea.MADINTYSHEROUK;
                        break;
                    case "Nasrcity":
                        d = CurrentArea.NASRCITY;
                        break;
                    case "Zamalek":
                        d = CurrentArea.ZAMALEK;
                        break;
                    case "New cairo":
                        d = CurrentArea.NEWCAIRO;
                        break;
                    default:
                        break;
                }
                String email = gui.getjTextField3().getText();

                String payment = (String)gui.getCombo3().getSelectedItem();
                boolean p = false; 
                if ("Yes".equals(payment))
                    p = true;
                else 
                    p = false;
                c.requestRide(l, d, email,p);
                //in request ride body function make a panel message or GUI window
                    //please           
            } catch (Exception ex) {
                Logger.getLogger(HomeWindow.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        
    }
    class ViewRideBtnAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                ClientReadOnly c = (ClientReadOnly) r.lookup("client_acc");  
                String email = gui.getjTextField4().getText(); 
                ArrayList <RequestRide> rides; 
                rides = c.viewRideHistory(email);
                JList<String> displaying = new JList<>(rides.toArray(new String[0]));
                JPanel displaypane = new JPanel();
                if (rides != null){
                JLabel label = new JLabel("Ride History");
                displaypane.add(label);
                displaypane.add(displaying); 
                displaypane.setVisible(true); 
                } else {
                    JOptionPane.showMessageDialog(gui,"No rides");
                }
                
                //test it ? 
            } catch (Exception ex) {
                Logger.getLogger(HomeWindow.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
    }
    class ComplaintBtnAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae){
             try {
                ClientReadOnly c = (ClientReadOnly) r.lookup("client_acc");  
                String rideID = gui.getjTextField1().getText(); 
                String email = gui.getjTextField2().getText();
                String complaint = gui.getjTextField5().getText(); 
                
                int id = Integer.parseInt(rideID); 
                c.giveComplaint(complaint, id, email);
                //make pop message in complain function body that complaint is done 
            } catch (Exception ex) {
                Logger.getLogger(HomeWindow.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
}
    class viewAccBtnAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae){
             try {
                ClientReadOnly c = (ClientReadOnly) r.lookup("client_acc");  
                String email = gui.getjTextField6().getText();
                String Result = c.viewOwnAccount(email); 
                JPanel account = new JPanel();
                if (Result != null) {
                JLabel a = new JLabel("Account Data"); 
                JLabel res = new JLabel(Result);
                account.add(a); 
                account.add(res); 
                account.setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(gui,"Account does not exist");
                } 
            } catch (Exception ex) {
                Logger.getLogger(HomeWindow.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
}
    class viewNotifBtnAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae){
             try {
                ClientReadOnly c = (ClientReadOnly) r.lookup("client_acc");  
                String email = gui.getjTextField7().getText();
                String notifications = c.viewNotifications(email); 
                if (notifications != null){
                    notfgui.setVisible(true);
                    notfgui.getTextField1().setText(notifications);
                }else {
                    JOptionPane.showMessageDialog(gui,"No Notifications");
                }
                //make pop message in complain function body that complaint is done 
            } catch (Exception ex) {
                Logger.getLogger(HomeWindow.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
    }
}
