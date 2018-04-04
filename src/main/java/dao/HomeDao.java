package dao;

import domain.Home;
import domain.Person;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

public class HomeDao {

    public Home create(Home home){

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
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
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
        EntityManager manager = factory.createEntityManager();
        Home home = manager.find(Home.class,id);
        manager.close();
        factory.close();
        return home;
    }

    public List<Home> getAllHome() {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
        EntityManager manager = factory.createEntityManager();
        return  manager.createQuery("SELECT e FROM Home e").getResultList();
    }



    public Home update(int homeId, Home _home) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Home home = manager.find(Home.class,homeId);
        if(manager.contains(home)){
            home.setTaille(_home.getTaille());
            home.setNbP(_home.getNbP());
            manager.merge(home);
            tx.commit();
        }
        else {
            System.out.println("id undefined");
        }
        manager.close();
        factory.close();
        return home;

    }

    public Home delete(int homeId) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Home home = manager.find(Home.class,homeId);
        manager.remove(home);
        tx.commit();
        manager.close();
        factory.close();
        return home;
    }
}
