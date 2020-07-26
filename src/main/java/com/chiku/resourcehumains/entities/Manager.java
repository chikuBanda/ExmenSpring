package com.chiku.resourcehumains.entities;

import lombok.AllArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "managers")
public class Manager extends Employe{

    @ManyToOne
    public DepAdminstratif dep;

    @OneToMany(targetEntity=NormalEmp.class,cascade = CascadeType.ALL , fetch = FetchType.LAZY, mappedBy = "manager")
    public List<NormalEmp> listEmp;

    public Manager(){}

    public Manager(long empID, @Size(min = 3, message = "minimum 3 lettre") String nom, @Size(min = 3, message = "minimum 3 lettre") String prenom, DepAdminstratif dep, List<NormalEmp> listEmp) {
        super(empID, nom, prenom);
        this.dep = dep;
        this.listEmp = listEmp;
    }

    public Department getDep() {
        return dep;
    }

    public void setDep(DepAdminstratif dep) {
        this.dep = dep;
    }

    public List<NormalEmp> getListEmp() {
        return listEmp;
    }

    public void setListEmp(List<NormalEmp> listEmp) {
        this.listEmp = listEmp;
    }
}
