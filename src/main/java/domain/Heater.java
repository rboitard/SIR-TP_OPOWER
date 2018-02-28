package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Heater extends SmartDevices {

    private int ID;

    private Home home;

    private String power;

    public Heater() {
        this.home = new Home();
    }

    @Id
    @GeneratedValue
    public int getID() {
        return ID;
    }

    @ManyToOne
    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

}
