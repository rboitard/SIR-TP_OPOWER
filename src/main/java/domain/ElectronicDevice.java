package domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class ElectronicDevice extends SmartDevices {

    private int  ConsommationMoyenne;
    private Person person;

    public ElectronicDevice(int consommationMoyenne) {
        ConsommationMoyenne = consommationMoyenne;
    }

    public ElectronicDevice() {
        ConsommationMoyenne = 0;
    }

    public int getConsommationMoyenne() {
        return ConsommationMoyenne;
    }

    public void setConsommationMoyenne(int consommationMoyenne) {
        ConsommationMoyenne = consommationMoyenne;
    }


    @ManyToOne
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }



}
