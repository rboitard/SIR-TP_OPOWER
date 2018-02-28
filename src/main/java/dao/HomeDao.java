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

    public Collection<Home> getAllHome() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
        EntityManager manager = factory.createEntityManager();
        Query query = manager.createQuery("SELECT e FROM Home e");
         Collection<Home> homes=  query.getResultList();
        manager.close();
        factory.close();
        return homes;
    }



    public Home update(Home home) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
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
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
        EntityManager manager = factory.createEntityManager();
        manager.remove(home);
        manager.flush();
        manager.close();
        factory.close();
    }
}
