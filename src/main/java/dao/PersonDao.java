package dao;

import domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Iterator;

public class PersonDao {


    public Person create(Person p){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
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
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
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
}
