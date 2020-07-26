package com.chiku.resourcehumains.services;

import com.chiku.resourcehumains.entities.Manager;
import com.chiku.resourcehumains.entities.NormalEmp;
import com.chiku.resourcehumains.exceptions.ResourceNotFoundException;

import java.util.List;

public interface ManagerService {
    void save(Manager manager);
    List<Manager> getManagers();
    Manager findById(long id) throws ResourceNotFoundException;
    void deleteById(long id);
}
