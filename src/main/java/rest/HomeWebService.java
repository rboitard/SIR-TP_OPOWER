package rest;

import dao.HomeDao;
import domain.Home;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;
import java.util.Iterator;

@Path("/home")
public class HomeWebService {

    private HomeDao daoHome = new HomeDao();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHome(@PathParam("id") int id) {
        Home home = daoHome.read(id);
        return Response.status(200).entity("taille : " + home.getTaille() + "nombre de pièces : " + home.getNbP()).build();
    }

    @POST
    public Response addHome(@FormParam("taille") int taille, @FormParam("nbP") int nbP){
        Home home = new Home(taille, nbP);
        daoHome.create(home);
        return Response.status(200).entity("AddHome is called, taille : " + taille + ", nombre de personnes : " + nbP ).build();
    }

    @PUT

    public Response update( @FormParam("taille") int taille, @FormParam("nbP") int nbP){
        Home home = new Home(taille, nbP);
        daoHome.update(home);
        return Response.status(200).entity("Update is called, taille : " + taille + ", nombre de personnes : " + nbP ).build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteHome(@PathParam("id") int id){
        daoHome.delete(daoHome.read(id));
        return Response.status(200).entity("deleteHome is called").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllhomes() {
        Collection<Home> homes = daoHome.getAllHome();
        String res=" ";
        Iterator<Home> iterator = homes.iterator();
        while (iterator.hasNext())
        {
            Home home = iterator.next();
            res += "taille : "+ home.getTaille() + ", nombre de personnes : " + home.getNbP()+ "\n";
        }
        return Response.status(200).entity(res).build();
    }
}
