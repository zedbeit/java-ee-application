/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import entities.Person;
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

/**
 *
 * @author Ubaita
 */

// api/identities/new
@Path("persons")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {
    
    @Inject
    PersonRepository personRepo;
    
    @Path("{id}")
    @GET
    public Response getPersonById(@PathParam("id") int id){
        return Response.ok(personRepo.findPersonById(id)).build();
    }
    
    @Path("list")
    @GET
    public Response getAllPersons(@PathParam("id") int id){
        return Response.ok(personRepo.findAllPersons()).build();
    }
    
    @Path("{identityId}")
    @POST
    public Response newPerson(@PathParam("identityId") int identityId, Person person){
        personRepo.createPerson(person, identityId);
        return Response.ok(person).build();
    }
    
    @Path("{personId}/{subjectId}")
    @GET
    public Person addPersonToSubject(@PathParam("subjectId") int subjectId, @PathParam("personId") int personId){
        return personRepo.addPersonToSubject(personId, subjectId);
    }  
    
}
