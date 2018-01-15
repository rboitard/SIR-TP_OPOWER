package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ElectronicDivice extends SmartDivices{

    private int  ConsommationMoyenne;
    private Person person;

    public ElectronicDivice(int consommationMoyenne) {
        ConsommationMoyenne = consommationMoyenne;
    }

    public ElectronicDivice() {
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
