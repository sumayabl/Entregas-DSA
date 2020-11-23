package edu.upc.dsa.services;

import edu.upc.dsa.Covid19Manager;
import edu.upc.dsa.Covid19ManagerImpl;
import edu.upc.dsa.PersonaNotFoundException;
import edu.upc.dsa.models.Laboratorio;
import edu.upc.dsa.models.Muestra;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Logger;

@Api(value = "/Orders", description = "Endpoint to Order Service")
@Path("/Orders")
public class MuestraService {

    final static Logger log = Logger.getLogger(MuestraService.class.getName());

    private Covid19Manager g;

    public MuestraService() {
        this.g = Covid19ManagerImpl.getInstance();
        if (g.size()==0) {
            Laboratorio laboratorio1 = new Laboratorio("AAA", "854126A");
            Laboratorio laboratorio2 = new Laboratorio("BBB", "854126B");
            Laboratorio laboratorio3 = new Laboratorio("CCC", "854126C");
            Laboratorio laboratorio4 = new Laboratorio("DDD", "854126D");
            g.addLaboratorio(laboratorio1);
            g.addLaboratorio(laboratorio2);
            g.addLaboratorio(laboratorio3);
            g.addLaboratorio(laboratorio4);

            g.addPersona("39411178A", "Sumaya", "Benali Laarif",12, "A");
            g.addPersona("38411178D", "Gerard", "Perez",15, "D");
        }
    }

    @POST
    @ApiOperation(value = "add Muestra", notes = "x")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/placeamuestra")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addOrder(Muestra o) throws PersonaNotFoundException {

        String idUser = o.getPersona().getIdPersona();

        try {
            this.g.addMuestra(idUser, o);
            return Response.status(201).build();
        } catch (PersonaNotFoundException e) {
            e.printStackTrace();
            return Response.status(404).build();
        }
    }

    @DELETE
    @ApiOperation(value = "get a muestra", notes = "x")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Muestra.class, responseContainer = "Muestra")
    })
    @Path("/getamuestra")
    @Produces(MediaType.APPLICATION_JSON)
    public Response serveAnOrder(){
        Muestra muestra = this.g.getMuestra();

        return Response.status(201).entity(muestra).build();
    }

    @GET
    @ApiOperation(value = "get all muestras of a user", notes = "x")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Muestra.class, responseContainer = "List of muestras"),
            @ApiResponse(code = 404, message = "Persona not found")
    })
    @Path("/{persona}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrders(@PathParam("persona") String persona) {
        List<Muestra> orders;
        try {
            orders = this.g.getAllMuestrasOfAUser(persona);
            log.info("Muestra: " + orders);
            GenericEntity<List<Muestra>> entity = new GenericEntity<List<Muestra>>(orders) {};
            return Response.status(201).entity(entity).build();
        } catch (PersonaNotFoundException e) {
            e.printStackTrace();
            return Response.status(404).build();
        }
    }
}
