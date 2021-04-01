/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import entities.Identity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ubaita
 */
@Stateless
public class IdentityRepository {
    
    @PersistenceContext
    private EntityManager em;
    
    public Identity createIdentity(Identity identity){
        em.persist(identity);
        return identity;
    }
   
    public Identity findIdentityById(int id){
        Identity identity = em.find(Identity.class, id);
        
        if(identity == null){
            throw new IllegalStateException("Identity does not exist");
        }
        return identity;
    }
    
    public List<Identity> findAllIdentities(){
        return em.createQuery("select i from Identity i", Identity.class).getResultList();
    }
}
