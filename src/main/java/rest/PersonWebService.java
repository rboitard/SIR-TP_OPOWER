package rest;

import dao.PersonDao;
import domain.Heater;
import domain.Home;
import domain.Person;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/person")
public class PersonWebService {

    private PersonDao daoP  = new PersonDao();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPerson(@PathParam("id") int id) {
        Person p = daoP.read(id);
        return Response.status(200).entity("name : " + p.getName() + ", prenom : " + p.getPrenom() + ", email" + p.getEmail()).build();
    }

    @POST
    public Response addPerson(@FormParam("nom") String nom, @FormParam("prenom") String prenom, @FormParam("email") String email){
        Person p = new Person(nom, prenom, email);
        daoP.create(p);
        return Response.status(200).entity("addPerson is called, name : " + nom + ", prenom : " + prenom + ", email :" + email).build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletePerson(@PathParam("id") int id){
        daoP.delete(daoP.read(id));
        return Response.status(200).entity("deletePerson is called").build();
    }



}
