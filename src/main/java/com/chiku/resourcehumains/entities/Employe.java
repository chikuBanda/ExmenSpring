package com.chiku.resourcehumains.entities;

import lombok.AllArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@MappedSuperclass
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long empID;

    @Size(min=3, message = "minimum 3 lettre")
    @Column(name = "nom" )
    public String nom;

    @Size(min=3, message = "minimum 3 lettre")
    @Column(name = "prenom" )
    public String prenom;

    public Employe(){}

    public Employe(long empID, @Size(min = 3, message = "minimum 3 lettre") String nom, @Size(min = 3, message = "minimum 3 lettre") String prenom) {
        this.empID = empID;
        this.nom = nom;
        this.prenom = prenom;
    }

    public long getEmpID() {
        return empID;
    }

    public void setEmpID(long empID) {
        this.empID = empID;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
