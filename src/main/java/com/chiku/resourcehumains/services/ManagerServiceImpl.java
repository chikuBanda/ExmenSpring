package com.chiku.resourcehumains.services;

import com.chiku.resourcehumains.entities.Manager;
import com.chiku.resourcehumains.entities.NormalEmp;
import com.chiku.resourcehumains.exceptions.ResourceNotFoundException;
import com.chiku.resourcehumains.repositories.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService{
    @Autowired
    ManagerRepository managerRepository;

    @Override
    public void save(Manager manager) {
        managerRepository.save(manager);
    }

    @Override
    public List<Manager> getManagers() {
        return (List<Manager>) managerRepository.findAll();
    }

    @Override
    public Manager findById(long id) throws ResourceNotFoundException {
        return (Manager) managerRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException(id)
        );
    }
}
