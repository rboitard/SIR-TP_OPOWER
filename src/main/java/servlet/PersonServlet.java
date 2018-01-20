package servlet;

import domain.Person;


import javax.persistence.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

/**
 * Created by 14005744 on 15/01/2018.
 */
@WebServlet(name="personInfo", urlPatterns={"/person"})
public class PersonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();


        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
        EntityManager manager = factory.createEntityManager();
        Iterator<Person> it = manager.createQuery("Select a From Person a", Person.class).getResultList().iterator();

        out.println("<HTML>\n<BODY>\n" +
                "<H1>Liste des Personnes</H1>\n");
        while(it.hasNext()){
            Person person = it.next();
            out.println("<UL>\n" +
                    " <LI>Nom: "
                    + person.getName() + "\n" +
                    " <LI>Prenom: "
                    + person.getPrenom() + "\n" +
                    " <LI>Mail: "
                    + person.getEmail() + "\n" +
                    "</UL>\n");
        }

        out.println("</BODY></HTML>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {
            Person newPerson = new Person(request.getParameter("name"), request.getParameter("firstname"), request.getParameter("email"));
            manager.persist(newPerson);
        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.commit();





        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<HTML>\n<BODY>\n" +
                "<H1>Nouvelle personne ajouté !</H1>\n");

        Iterator<Person> it = manager.createQuery("Select a From Person a", Person.class).getResultList().iterator();

        out.println("<HTML>\n<BODY>\n" +
                "<H1>Liste des Personnes</H1>\n");
        while(it.hasNext()){
            Person person = it.next();
            out.println("<UL>\n" +
                    " <LI>Nom: "
                    + person.getName() + "\n" +
                    " <LI>Prenom: "
                    + person.getPrenom() + "\n" +
                    " <LI>Mail: "
                    + person.getEmail() + "\n" +
                    "</UL>\n");
        }

        out.println("</BODY></HTML>");
        manager.close();
        factory.close();
    }
}
