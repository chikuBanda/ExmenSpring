package com.chiku.resourcehumains.services;

import com.chiku.resourcehumains.entities.DepAdminstratif;
import com.chiku.resourcehumains.entities.DepService;
import com.chiku.resourcehumains.exceptions.ResourceNotFoundException;
import com.chiku.resourcehumains.repositories.DepServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepServServiceImpl implements DepServService{
    @Autowired
    DepServiceRepository depServiceRepository;

    @Override
    public void save(DepService depService) {
        depServiceRepository.save(depService);
    }

    @Override
    public List<DepService> getDeps() {
        return (List<DepService>) depServiceRepository.findAll();
    }

    @Override
    public DepService findById(long id) throws ResourceNotFoundException {
        return (DepService) depServiceRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException(id)
        );
    }

    @Override
    public void deleteById(long id) {
        depServiceRepository.deleteById(id);
    }
}
