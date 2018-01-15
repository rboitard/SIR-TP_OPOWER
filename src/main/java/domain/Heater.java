package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Heater extends SmartDivices{

    private Home home;

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


}
