/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import entities.Identity;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import repositories.IdentityRepository;

/**
 *
 * @author Ubaita
 */

// api/identities/new
@Path("identities")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class IdentityResource {
    
    @Inject
    IdentityRepository identityRepo;
    
    @Path("list")
    @GET
    public Response getIdentities(){
        return Response.ok(identityRepo.findAllIdentities()).build();
    }
    
    @Path("{id}")
    @GET
    public Response getIdentitiesById(@PathParam("id") int id){
        return Response.ok(identityRepo.findIdentityById(id)).build();
    }
    
    @Path("new")
    @POST
    public Response newIdentity(Identity identity){
        identityRepo.createIdentity(identity);
        return Response.ok(identity).build();
    }   
}
