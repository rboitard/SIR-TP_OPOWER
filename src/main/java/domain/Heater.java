package domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Heater extends SmartDevices {

    private Home home;

    private String power;

    public Heater(String name) {
        this.home = new Home();
    }

    public Heater() {
        this.home = new Home();
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

}
