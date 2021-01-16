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
import java.text.SimpleDateFormat;
import java.util.Date;
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
        }
    class RequestBtnAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                CurrentArea l = null; 
                CurrentArea d = null;
                ClientReadOnly c = (ClientReadOnly) r.lookup("client_acc");
                String loc = (String)gui.getCombo().getSelectedItem();
                if ("Maadi".equals(loc)){
                    l = CurrentArea.MAADI; 
                }else if ("MadintySherouk".equals(loc)){
                   l = CurrentArea.MADINTYSHEROUK;
                }else if("Nasrcity".equals(loc)){
                    l = CurrentArea.NASRCITY;
                }else if ("Zamalek".equals(loc)){
                    l = CurrentArea.ZAMALEK;
                }else if ("New cairo".equals(loc)){
                    l = CurrentArea.NEWCAIRO;
                };
                String dest = (String)gui.getCombo2().getSelectedItem();
                if ("Maadi".equals(dest)){
                    d = CurrentArea.MAADI; 
                }else if ("MadintySherouk".equals(dest)){
                    d= CurrentArea.MADINTYSHEROUK;
                }else if("Nasrcity".equals(dest)){
                    d = CurrentArea.NASRCITY;
                }else if ("Zamalek".equals(dest)){
                    d = CurrentArea.ZAMALEK;
                }else if ("New cairo".equals(dest)){
                    d = CurrentArea.NEWCAIRO;
                };
                String email = gui.getjTextField3().getText();

                c.requestRide(l, d, email,true);
                //add login action what happens 
                               
            } catch (Exception ex) {
                Logger.getLogger(HomeWindow.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        
    }
}
