package jpa;

import domain.Person;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Iterator;
import java.util.List;

public class JpaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
		EntityManager manager = factory.createEntityManager();

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {

   			 Person person1 = new Person("martin", "martP","marting@gmail.com");
			 Person person2 = new Person("martin2", "martP","marting@gmail.com");
			 manager.persist(person1);
			 manager.persist(person2);

		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		/*String s = "SELECT e FROM Person as e where e.name=:name";
		
		Query q = manager.createQuery(s,Person.class);
		q.setParameter("name", "martin");
		List<Person> res = q.getResultList();
		
		System.err.println(res.size());
		System.err.println(res.get(0).getName());
		
		manager.close();
		factory.close();*/

		// creteria query
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		CriteriaQuery<String>  query = criteriaBuilder.createQuery(String.class);
		Root<Person> from = query.from(Person.class);
		CriteriaQuery<String> query1 = query.select(from.<String>get("name")).where(from.get("name").in("martin"));
		TypedQuery<String> findAllBooks = manager.createQuery(query1);
		List list = findAllBooks.getResultList();
		Iterator it = list.iterator();
		System.out.println("begin dispay");
		while(it.hasNext()){
			System.out.println("value : " + it.next());
		}



		System.out.println("done ...");
	}



}
