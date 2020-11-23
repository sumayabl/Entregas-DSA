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
import io.swagger.annotations.Api;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Logger;
import javax.ws.rs.*;

@Api(value = "/Products", description = "Endpoint to Product Service")
@Path("/Products")
public class LaboratorioService {

    private Covid19Manager g;

    public LaboratorioService() {
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
        }
    }

    @POST
    @ApiOperation(value = "create a new Laboratorio", notes = "---")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=Laboratorio.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newProduct(Laboratorio laboratorio) {

        if (laboratorio.getIdLab()==null || laboratorio.getNombreLab()==null || laboratorio.getNumLabs()==0)  return Response.status(500).entity(laboratorio).build();
        this.g.addLaboratorio(laboratorio);
        return Response.status(201).entity(laboratorio).build();
    }

    @GET
    @ApiOperation(value = "get all Laboratorios", notes = "---")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Laboratorio.class, responseContainer="List of all laboratorios"),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProducts() {

        List<Laboratorio> products = this.g.allLaboratorios();

        GenericEntity<List<Laboratorio>> entity = new GenericEntity<List<Laboratorio>>(products) {};
        return Response.status(201).entity(entity).build()  ;

    }
}
