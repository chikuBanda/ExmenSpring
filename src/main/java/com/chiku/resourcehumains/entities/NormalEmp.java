package com.chiku.resourcehumains.entities;

import lombok.AllArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "normal_emps")
public class NormalEmp extends Employe{

    @ManyToOne
    public DepService dep;

    @ManyToOne
    public Manager manager;

    public NormalEmp(){}

    public NormalEmp(long empID, @Size(min = 3, message = "minimum 3 lettre") String nom, @Size(min = 3, message = "minimum 3 lettre") String prenom, DepService dep, Manager manager) {
        super(empID, nom, prenom);
        this.dep = dep;
        this.manager = manager;
    }

    public Department getDep() {
        return dep;
    }

    public void setDep(DepService dep) {
        this.dep = dep;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
