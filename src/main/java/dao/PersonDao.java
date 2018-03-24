package dao;

import domain.Home;
import domain.Person;

import javax.persistence.*;
import java.util.Collection;
import java.util.Iterator;

public class PersonDao {


    public Person create(Person p){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(p);
        tx.commit();
        manager.close();
        factory.close();
        return p;
    }

    public Person read(int id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
        EntityManager manager = factory.createEntityManager();
        Person person = manager.find(Person.class, id);
        manager.close();
        factory.close();
        return person;

    }



    public Person update(Person p) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.merge(p);
        tx.commit();
        manager.close();
        factory.close();
        return p;

    }



    public void delete(Person p) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
        EntityManager manager = factory.createEntityManager();
        manager.remove(p);
        manager.flush();
        manager.close();
        factory.close();
    }

    public Collection<Person> getAllPerson() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
        EntityManager manager = factory.createEntityManager();
        Query query = manager.createQuery("SELECT e FROM Person e");
        Collection<Person> personCollection =  query.getResultList();
        manager.close();
        factory.close();
        return personCollection;
    }
}
