package rmi;

import rmi.Interface.CarInterface;
import rmi.ReadOnly.DriverReadOnly;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Car extends UnicastRemoteObject implements DriverReadOnly, Serializable, CarInterface{
    String carModel;
    String plateNum;
    String carColor;

    //Constructer  
    public Car() throws RemoteException{
    }

    public Car(String carModel, String plateNum, String carColor) throws RemoteException{
        this.carColor=carColor;
        this.carModel=carModel;
        this.plateNum=plateNum;
    }
    
    //Setter And Getters
    public String getCarModel() {
        return carModel;
    }
    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }
    public String getPlateNum() {
        return plateNum;
    }
    public void setPlateNum(String plateNum) {
        this.plateNum = plateNum;
    }
    public String getCarColor() {
        return carColor;
    }
    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    @Override
    public void updateCar(String mail ,String CM, String PN, String CC) throws RemoteException{
        Driver driver = new Driver();
        DB db = new DB();
        driver = db.retrieveDriverByMail(mail);

        Car new_Car = new Car();

        new_Car.setCarColor(CC);
        new_Car.setCarModel(CM);
        new_Car.setPlateNum(PN);

        driver.setCar(new_Car);
        db.updateDriver(driver);
    }

    /*Account*/
    @Override
    public String viewOwnAccount(String email) throws RemoteException {
        return null;
    }
    @Override
    public boolean login(String email, String password) throws RemoteException {
        return false;
    }

    /*Ride*/
    @Override
    public void acceptRide(int x) throws RemoteException {

    }
    @Override
    public void declineRide(int x) throws RemoteException {

    }
    @Override
    public ArrayList<Ride> viewRideHistory() throws RemoteException {
        return null;
    }

    /*Complaint*/
    @Override
    public void giveComplaint(String msg, int rideID, String email) throws RemoteException {

    }
}
