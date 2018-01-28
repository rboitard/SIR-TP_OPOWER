package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Person {

    private String name;
    private String prenom;
    private String email;
    private int ID;
    private List<Home> homes;
    private List<ElectronicDevice>  electronicDivices;


    public Person()
    {
        this.homes  = new ArrayList<Home>();
        this. electronicDivices =  new ArrayList<ElectronicDevice>();
        this.name ="";
        this.prenom ="";
        this.email = "";

    }

    public Person(String nom, String prenom, String email) {

        this.homes = new ArrayList<Home>();
        this. electronicDivices =  new ArrayList<ElectronicDevice>();
        this.name = nom;
        this.prenom = prenom;
        this.email = email;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Id
    @GeneratedValue
    public int getID() {
        return ID;
    }


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person" )
    public List<Home> getHomes() {
        return homes;
    }


    public void setHomes(List<Home> homes) {
        this.homes = homes;
    }

    @OneToMany(mappedBy = "person")
    public List<ElectronicDevice> getElectronicDivices() {
        return electronicDivices;
    }

    public void setElectronicDivices(List<ElectronicDevice> electronicDivices) {
        this.electronicDivices = electronicDivices;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", ID=" + ID +
                '}';
    }
}
