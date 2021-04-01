/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import entities.Identity;
import entities.Person;
import entities.Subject;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.Response;

/**
 *
 * @author Ubaita
 */
@Stateless
public class SubjectRepository {
    
    @PersistenceContext
    private EntityManager em;
    
    public Subject createSubject(Subject subject){
        em.persist(subject);
        return subject;
    }
    
    public Subject addSubjectToPerson(int personId, int subjectId){
    
        Person person = em.find(Person.class, personId);
        Subject subject = em.find(Subject.class, subjectId);
        
        if(person == null && subject == null){
            throw new IllegalStateException("Invalid Operation");
        }
        
        List<Subject> listOfSubjects = person.getSubjects();
        listOfSubjects.add(subject);
        
        person.setSubjects(listOfSubjects);
        
        subject.getPersons().add(person);

        return subject;
    }
    

    public Subject findSubjectById(int id){
        Subject subject = em.find(Subject.class, id);
        
        if(subject == null){
            throw new IllegalStateException("Subject does not exist");
        }
        return subject; 
    }
//    
    public List<Subject> findAllSubjects(){
        return em.createQuery("select s from Subject s", Subject.class).getResultList();
    }
}
