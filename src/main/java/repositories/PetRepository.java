/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import entities.Identity;
import entities.Person;
import entities.Pet;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ubaita
 */
@Stateless
public class PetRepository {
    
    @PersistenceContext
    private EntityManager em;
    
    public Pet createPet(Pet pet, int personId, int identityId){
        Person person = em.find(Person.class, personId);
        Identity identity = em.find(Identity.class, identityId);
        
        if(person == null && identity == null){
            throw new IllegalStateException("Invalid Pet");
        }
        
        pet.setPersonId(person);
        pet.setIdentityId(identity);
        
        List<Pet> listOfPets = person.getPets();
        listOfPets.add(pet);
        
        person.setPets(listOfPets);
         
        em.persist(pet);
        
        return pet;
    }
    
    public Pet findPetById(int id){
        Pet pet = em.find(Pet.class, id);
        
        if(pet == null){
            throw new IllegalStateException("Person does not exist");
        }
        return pet; 
    }
    
    public List<Pet> findAllPets(){
        return em.createQuery("select p from Pet p", Pet.class).getResultList();
    }
    
}
