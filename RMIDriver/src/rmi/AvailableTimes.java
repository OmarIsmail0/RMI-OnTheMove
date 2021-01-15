package rmi;

import java.io.Serializable;

public class AvailableTimes implements Serializable {
    String day;

    public AvailableTimes(){

    }

    public AvailableTimes(String day) {
        this.day = day;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
