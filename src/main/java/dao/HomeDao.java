package dao;

import domain.Home;
import domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class HomeDao {

    public Home create(Home home){

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(home);
        tx.commit();
        manager.close();
        factory.close();
        return home;
    }

    public Home read(int id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
        EntityManager manager = factory.createEntityManager();
        Home home = manager.find(Home.class, id);
        manager.close();
        factory.close();
        return home;

    }



    public Home update(Home home) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.merge(home);
        tx.commit();
        manager.close();
        factory.close();
        return home;

    }



    public void delete(Home home) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
        EntityManager manager = factory.createEntityManager();
        manager.remove(home);
        manager.flush();
        manager.close();
        factory.close();
    }
}
