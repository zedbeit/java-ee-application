/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import entities.Subject;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import repositories.SubjectRepository;

/**
 *
 * @author Ubaita
 */

// api/identities/new
@Path("subjects")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SubjectResource {
    
    @Inject
    SubjectRepository subjectRepo;
    
    @GET
    public Response sayHello(){
        return Response.ok("Hello from subjects").build();
    }
    
    @Path("new")
    @POST
    public Response newSubject(Subject subject){
        subjectRepo.createSubject(subject);
        return Response.ok(subject).build();
    }  
    
    @Path("{personId}/{subjectId}")
    @GET
    public Subject addSubjectToPerson(@PathParam("subjectId") int subjectId, @PathParam("personId") int personId){
        return subjectRepo.addSubjectToPerson(personId, subjectId);
    }
    
    @Path("{id}")
    @GET
    public Response getSubjectById(@PathParam("id") int id){
        return Response.ok(subjectRepo.findSubjectById(id)).build();
    }
    
    @Path("list")
    @GET
    public Response getAllSubjects(@PathParam("id") int id){
        return Response.ok(subjectRepo.findAllSubjects()).build();
    }
    
}
