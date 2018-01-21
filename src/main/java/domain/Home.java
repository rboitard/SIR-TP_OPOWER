package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Home {

    private int ID;
    private  int taille;
    private int nbP ;
    private Person person;
    private List<Heater> heaters;
    private String name;

    public Home(int taille, int nbP, Person person) {
        this.taille = taille;
        this.nbP = nbP;
        this.person = person;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @OneToMany(mappedBy = "home")
    public List<Heater> getHeaters() {
        return heaters;
    }

    public void setHeaters(List<Heater> heaters) {
        this.heaters = heaters;
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
                ", person=" + person.getName() +
                '}';
    }
}
