package rest;

import dao.HomeDao;
import domain.Home;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/home")
public class HomeWebService {

    private HomeDao daoHome = new HomeDao();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHome(@PathParam("id") int id) {
        Home home =daoHome.read(id);
        return response(home);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response addHome(Home home){
        return this.response(daoHome.create(home));
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id,  Home home){
       return response(daoHome.update(id, home)) ;
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteHome(@PathParam("id") int id){
        daoHome.delete(id);
    }


    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response homes() {
        return this.response(this.daoHome.getAllHome());
    }

    private Response response(Object o) {
        return Response.ok(o).build();
    }
}
