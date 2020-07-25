package com.chiku.resourcehumains.entities;

import lombok.AllArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@MappedSuperclass
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long depID;

    @Size(min=3, message = "minimum 3 lettre")
    @Column(name = "nom" )
    private String nom;

    public Department(){}

    public Department(long depID, @Size(min = 3, message = "minimum 3 lettre") String nom) {
        this.depID = depID;
        this.nom = nom;
    }

    public long getDepID() {
        return depID;
    }

    public void setDepID(long depID) {
        this.depID = depID;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
