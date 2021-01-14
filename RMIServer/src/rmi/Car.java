package rmi;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Car extends UnicastRemoteObject implements CarInterface, Serializable{
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
}
