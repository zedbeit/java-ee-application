/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Ubaita
 */
@Entity
@Table(name = "persons")
public class Person implements Serializable {
    
    @Id
    @Column(name = "person_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer personId;
    
    @NotNull
    @Column(name = "person_name")
    private String personName;
    
    @NotNull
    @Column(name = "person_gender")
    private String gender;
    
    @OneToOne
    private Identity identityId;

    public Identity getIdentityId() {
        return identityId;
    }

    public void setIdentityId(Identity identityId) {
        this.identityId = identityId;
    }
    
    @OneToMany(mappedBy = "personId", cascade = CascadeType.ALL)
    private List<Pet> pets = new ArrayList<>();
    
    @JsonbTransient
    @ManyToMany(mappedBy = "persons", cascade = CascadeType.ALL)
    private List<Subject> subjects = new ArrayList<>();

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    
    

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
    
    public List<Subject> getSubjects() {
        return subjects;
    }
  
    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
