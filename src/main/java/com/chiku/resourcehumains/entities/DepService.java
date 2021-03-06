package com.chiku.resourcehumains.entities;

import lombok.AllArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "dep_services")
public class DepService extends Department{

    @OneToMany(targetEntity=NormalEmp.class,cascade = CascadeType.ALL , fetch = FetchType.LAZY, mappedBy = "dep")
    public List<NormalEmp> listEmp;

    public DepService(){}

    public DepService(long depID, @Size(min = 3, message = "minimum 3 lettre") String nom, List<NormalEmp> listEmp) {
        super(depID, nom);
        this.listEmp = listEmp;
    }
}
