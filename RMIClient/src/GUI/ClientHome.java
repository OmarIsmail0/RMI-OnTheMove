package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.registry.Registry;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import rmi.*;
import rmi.ReadOnly.ClientReadOnly;

import javax.swing.*;

public class ClientHome {
    ClientHomeGUI gui;
    NotificationHome notfgui = new NotificationHome();
    Registry r;

    public ClientHome(ClientHomeGUI gui, Registry r) {
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
                ClientReadOnly c = (ClientReadOnly) r.lookup("Client Ride");
                String loc = (String) gui.getCombo().getSelectedItem();
                if ("Maadi".equals(loc)) {
                    l = CurrentArea.MAADI;
                } else if ("MadintySherouk".equals(loc)) {
                    l = CurrentArea.MADINTYSHEROUK;
                } else if ("Nasrcity".equals(loc)) {
                    l = CurrentArea.NASRCITY;
                } else if ("Zamalek".equals(loc)) {
                    l = CurrentArea.ZAMALEK;
                } else if ("New cairo".equals(loc)) {
                    l = CurrentArea.NEWCAIRO;
                }
                ;
                String dest = (String) gui.getCombo2().getSelectedItem();
                if ("Maadi".equals(dest)) {
                    d = CurrentArea.MAADI;
                } else if ("MadintySherouk".equals(dest)) {
                    d = CurrentArea.MADINTYSHEROUK;
                } else if ("Nasrcity".equals(dest)) {
                    d = CurrentArea.NASRCITY;
                } else if ("Zamalek".equals(dest)) {
                    d = CurrentArea.ZAMALEK;
                } else if ("New cairo".equals(dest)) {
                    d = CurrentArea.NEWCAIRO;
                }
                ;
                String email = gui.getjTextField3().getText();

                String payment = (String) gui.getCombo3().getSelectedItem();
                boolean p = false;
                if ("Yes".equals(payment))
                    p = true;
                else
                    p = false;
                c.requestRide(l, d, email, p);
                //in request ride body function make a panel message or GUI window
                //please
            } catch (Exception ex) {
                Logger.getLogger(HomeWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    class ViewRideBtnAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                Ride rsss = new Ride();
                ClientReadOnly c = (ClientReadOnly) r.lookup("Client Ride");
                String email = gui.getjTextField4().getText();
                ArrayList<RequestRide> rides = new ArrayList<>();
                rides = c.viewRideHistory(LoginWindow.loginMail);
                String msg = "";
                for (int i = 0; i < rides.size(); i++){

                   msg += rsss.display(rides.get(i));
                }
                JPanel displaypane = new JPanel();
                if (!rides.isEmpty()) {
                   /* JLabel label = new JLabel("Ride History");
                    displaypane.add(label);
                    displaypane.add(displaying);*/
                    displaypane.setVisible(true);
                    JOptionPane.showMessageDialog(gui, msg);
                } else {
                    JOptionPane.showMessageDialog(gui, "No rides");
                }

                //test it ? 
            } catch (Exception ex) {
                Logger.getLogger(HomeWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    class ComplaintBtnAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                ClientReadOnly c = (ClientReadOnly) r.lookup("Client Complaint");
                String rideID = gui.getjTextField1().getText();
                //String email = gui.getjTextField2().getText();
                String complaint = gui.getjTextField5().getText();

                int id = Integer.parseInt(rideID);
                c.giveComplaint(complaint, id, LoginWindow.loginMail);
                //make pop message in complain function body that complaint is done 
            } catch (Exception ex) {
                Logger.getLogger(HomeWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    class viewAccBtnAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {

                ClientReadOnly c = (ClientReadOnly) r.lookup("Client Account");
                String email = gui.getjTextField6().getText();
                String Result = c.viewOwnAccount(LoginWindow.loginMail);
                JPanel account = new JPanel();
                if (!Result.isEmpty()) {
                  /*  JLabel a = new JLabel("Account Data");
                    JLabel res = new JLabel(Result);
                    account.add(a);
                    account.add(res);*/
                    account.setVisible(true);
                    JOptionPane.showMessageDialog(gui, Result);
                } else {
                    JOptionPane.showMessageDialog(gui, "Account does not exist");
                }
                System.out.println(Result);
            } catch (Exception ex) {
                Logger.getLogger(HomeWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    class viewNotifBtnAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                ClientReadOnly c = (ClientReadOnly) r.lookup("Client Notify");
                String email = gui.getjTextField7().getText();
                String notifications = c.viewNotifications(LoginWindow.loginMail);
                if (!notifications.isEmpty()) {
                    notfgui.setVisible(true);
                    notfgui.getTextField1().setText(notifications);
                } else {
                    JOptionPane.showMessageDialog(gui, "No Notifications");
                }
                //make pop message in complain function body that complaint is done 
            } catch (Exception ex) {
                Logger.getLogger(HomeWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
