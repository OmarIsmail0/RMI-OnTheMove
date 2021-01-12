package rmi;

public class Car {
    String carModel;
    String plateNum;
    String carColor;

    //Constructer
    public Car(String carModel, String plateNum, String carColor) {
        this.carModel = carModel;
        this.plateNum = plateNum;
        this.carColor = carColor;
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
    
    //Methods
    public void updateCar(String CM, String PN, String CC){
        
    }
}
