package edu.upc.dsa.services;

import edu.upc.dsa.Covid19Manager;
import edu.upc.dsa.Covid19ManagerImpl;
import edu.upc.dsa.models.Persona;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;

@Api(value = "/Personas", description = "Endpoint to Persona Service")
@Path("/Perosnas")
public class PersonaService {
    final Covid19Manager g;

    public PersonaService() {
        this.g = Covid19ManagerImpl.getInstance();
        if (g.size()==0) {
            this.g.addPersona("39411178A", "Sumaya", "Benali Laarif",12, "A");
            this.g.addPersona("39412178B", "Suhail", "Chaib Akdim",20, "B");
            this.g.addPersona("39511178C", "Meritxell", "Hermoso",43, "C");
            this.g.addPersona("38411178D", "Gerard", "Perez",15, "D");
        }
    }



    @GET
    @ApiOperation(value = "get a Persona", notes = "---")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Persona.class),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersona(@PathParam("id") String idPersona) {
        Persona p = this.g.getPersona(idPersona);
        if (p == null) return Response.status(404).build();
        else  return Response.status(201).entity(p).build();
    }

    @POST
    @ApiOperation(value = "create a new Persona", notes = "---")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Persona.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newPersona(Persona persona) {

        if (persona.getIdPersona()==null || persona.getNombre()==null || persona.getApellidos()==null || persona.getEdad()==0 || persona.getNivelSalud()==null)  return Response.status(500).entity(persona).build();
        this.g.addPersona(persona.getIdPersona(), persona.getNombre(), persona.getApellidos(), persona.getEdad(), persona.getNivelSalud());
        return Response.status(201).entity(persona).build();
    }

    @GET
    @ApiOperation(value = "get all users in the list", notes = "x")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Persona.class, responseContainer = "List of Users")
    })
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPersonas() {
        HashMap<String, Persona> personas  = this.g.allPersonas();

        GenericEntity<HashMap<String, Persona>> entity = new GenericEntity<HashMap<String, Persona>>(personas){};
        return Response.status(201).entity(entity).build();
    }
}
