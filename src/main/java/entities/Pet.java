/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Ubaita
 */
@Entity
@Table(name = "pets")
public class Pet implements Serializable {
    
    @Id
    @Column(name = "pet_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer petId;
    
    @NotNull
    @Column(name = "pet_name")
    private String petName;
    
    @JsonbTransient
    @NotNull
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person personId;
    
    @JsonbTransient
    @OneToOne
    @NotNull
    @JoinColumn(name = "identity_id")
    private Identity identityId;

    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    
    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    public Identity getIdentityId() {
        return identityId;
    }

    public void setIdentityId(Identity identityId) {
        this.identityId = identityId;
    }

    
}
