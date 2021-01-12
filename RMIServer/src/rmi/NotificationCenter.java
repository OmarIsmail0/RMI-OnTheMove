/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;
import java.util.ArrayList;
/**
 *
 * @author USCS
 */
public class NotificationCenter {
    ArrayList<Observer> observers = new ArrayList<Observer>();
    int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyObservers();
    }
    
     public void addObserver(Observer observer){
      observers.add(observer);		
   }

    public void notifyObservers(){
      for (Observer observer : observers) {
         observer.update();
      }
    }
}
