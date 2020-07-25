package com.chiku.resourcehumains.entities;

import lombok.AllArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "dep_administratifs")
public class DepAdminstratif extends Department{

    @OneToMany()
    @JoinColumn(name="dep_depid")
    public List<Manager> listEmp;

    public DepAdminstratif(){}

    public DepAdminstratif(long depID, @Size(min = 3, message = "minimum 3 lettre") String nom, List<Manager> listEmp) {
        super(depID, nom);
        this.listEmp = listEmp;
    }
}
