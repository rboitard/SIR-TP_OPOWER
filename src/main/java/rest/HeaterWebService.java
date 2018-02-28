package rest;

import dao.HeaterDao;
import domain.Heater;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/heater")
public class HeaterWebService {
    private HeaterDao daoH  = new HeaterDao();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPerson(@PathParam("id") int id) {
        Heater h = daoH.read(id);
        return Response.status(200).entity("power : " + h.getPower() + ", home : " + h.getHome()).build();
    }

    @POST
    public Response addHeater(@FormParam("power") String power){
        Heater h = new Heater();
        h.setPower(power);
        daoH.create(h);
        return Response.status(200).entity("addHeater is called, power : " + power).build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletePerson(@PathParam("id") int id){
        daoH.delete(daoH.read(id));
        return Response.status(200).entity("deleteHeater is called").build();
    }
}
