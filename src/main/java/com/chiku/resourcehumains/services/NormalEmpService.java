package com.chiku.resourcehumains.services;

import com.chiku.resourcehumains.entities.NormalEmp;
import com.chiku.resourcehumains.exceptions.ResourceNotFoundException;

import java.util.List;

public interface NormalEmpService {
    public void save(NormalEmp normalEmp);
    List<NormalEmp> getEmps();
    NormalEmp findById(long id) throws ResourceNotFoundException;
    public void deleteById(long id);
}
