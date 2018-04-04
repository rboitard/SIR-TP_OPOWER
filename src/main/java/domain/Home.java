package domain;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Home  {

    private int ID;
    private  int taille;
    private int nbP ;
    private Person person;
    private List<Heater> heaters;

    public Home(int taille, int nbP) {
        this.taille = taille;
        this.nbP = nbP;
        this.person = new Person();
        this.heaters =  new ArrayList<Heater>();
    }

    public Home() {
        this.taille = 0;
        this.nbP = 0;
        this.person = new Person();
        this.heaters =  new ArrayList<Heater>();
    }

    @Id
    @GeneratedValue
    public int getID() {
        return ID;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public int getNbP() {
        return nbP;
    }

    public void setNbP(int nbP) {
        this.nbP = nbP;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "home")
    public List<Heater> getHeaters() {
        return heaters;
    }

    public void setHeaters(List<Heater> heaters) {
        this.heaters = heaters;
    }

    public void addHeater(Heater heater)
    {
        this.heaters.add(heater);
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void addDevice(Heater heater){
        this.heaters.add(heater);
    }

    @Override
    public String toString() {
        return "Home{" +
                "ID=" + ID +
                ", taille=" + taille +
                ", nbP=" + nbP +
                '}';
    }
}
