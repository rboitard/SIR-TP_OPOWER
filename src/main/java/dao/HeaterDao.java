package dao;

import domain.Heater;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class HeaterDao {
    public Heater create(Heater heater){

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(heater);
        tx.commit();
        manager.close();
        factory.close();
        return heater;
    }

    public Heater read(int id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
        EntityManager manager = factory.createEntityManager();
        Heater heater = manager.find(Heater.class, id);
        manager.close();
        factory.close();
        return heater;

    }



    public Heater update(Heater heater) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.merge(heater);
        tx.commit();
        manager.close();
        factory.close();
        return heater;

    }



    public void delete(Heater heater) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
        EntityManager manager = factory.createEntityManager();
        manager.remove(heater);
        manager.flush();
        manager.close();
        factory.close();
    }
}
