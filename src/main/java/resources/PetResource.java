/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import entities.Identity;
import entities.Person;
import entities.Pet;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import repositories.PersonRepository;
import repositories.PetRepository;

/**
 *
 * @author Ubaita
 */

// api/identities/new
@Path("pets")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PetResource {
    
    @Inject
    PetRepository petRepo;
    
    @POST
    @Path("{personId}/{identityId}")
    public Pet createPet(@PathParam("personId") int personId, @PathParam("identityId") int identityId, Pet pet){
        return petRepo.createPet(pet,personId,identityId);
    }
    
    @Path("{id}")
    @GET
    public Response getPetById(@PathParam("id") int id){
        return Response.ok(petRepo.findPetById(id)).build();
    }
    
    @Path("list")
    @GET
    public Response getAllPets(@PathParam("id") int id){
        return Response.ok(petRepo.findAllPets()).build();
    }
}
