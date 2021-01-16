/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

import rmi.ClientHomeGUI;
import rmi.CurrentArea;
import rmi.ReadOnly.ClientReadOnly;


public class ClientHome {
    ClientHomeGUI gui;
    Registry r;
    
    public ClientHome(ClientHomeGUI gui, Registry r)
        {
            this.gui = gui;
            this.r = r;
            gui.getjButton1().addActionListener(new ClientHome.RequestBtnAction());    
            gui.getjButton2().addActionListener(new ClientHome.ViewRideBtnAction());
            gui.getjButton3().addActionListener(new ClientHome.ComplaintBtnAction());
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
                //in login functino go to the next gui for home client if login is correct..
                //add login action what happens 
                               
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
                String acc = gui.getjTextField4().getText(); 
                //c.viewRideHistory(); //add parameters 3nd 3omar 
                //not fiinished
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
                //make pop message -> done !
            } catch (Exception ex) {
                Logger.getLogger(HomeWindow.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
}
}
