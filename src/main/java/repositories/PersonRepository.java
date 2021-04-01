/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import entities.Identity;
import entities.Person;
import entities.Subject;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ubaita
 */
@Stateless
public class PersonRepository {
    
    @PersistenceContext
    private EntityManager em;
    
    public Person createPerson(Person person, int identityId){
        Identity identity = em.find(Identity.class, identityId);
        
        if(identity == null){
            throw new IllegalStateException("Identity does not exist!");
        }
        
        person.setIdentityId(identity);
//        identity.setPerson(person);
        
        em.persist(person);
        return person;
    }
    
    public Person findPersonById(int id){
        Person person = em.find(Person.class, id);
        
        if(person == null){
            throw new IllegalStateException("Person does not exist");
        }
        return person; 
    }
    
    public List<Person> findAllPersons(){
        return em.createQuery("select p from Person p", Person.class).getResultList();
    }
    
    public Person addPersonToSubject(int personId, int subjectId){
    
        Person person = em.find(Person.class, personId);
        Subject subject = em.find(Subject.class, subjectId);
        
        if(person == null && subject == null){
            throw new IllegalStateException("Invalid Operation");
        }
        
        List<Person> listOfPersons = subject.getPersons();
        listOfPersons.add(person);
        
        subject.setPersons(listOfPersons);
        
        person.getSubjects().add(subject);
        
        return person;
    } 
}
