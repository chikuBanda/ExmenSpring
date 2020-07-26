package com.chiku.resourcehumains.services;

import com.chiku.resourcehumains.entities.DepAdminstratif;
import com.chiku.resourcehumains.entities.Manager;
import com.chiku.resourcehumains.exceptions.ResourceNotFoundException;
import com.chiku.resourcehumains.repositories.DepAdministratifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DepAdministratifServiceImpl implements DepAdministratifService{

    @Autowired
    DepAdministratifRepository depAdministratifRepository;

    @Override
    @Transactional
    public void save(DepAdminstratif depAdminstratif) {
        depAdministratifRepository.save(depAdminstratif);
    }

    @Override
    public List<DepAdminstratif> getDeps() {
        return (List<DepAdminstratif>) depAdministratifRepository.findAll();
    }

    @Override
    public DepAdminstratif findById(long id) throws ResourceNotFoundException {
        return (DepAdminstratif) depAdministratifRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException(id)
        );
    }

    @Override
    public void deleteById(long id) {
        depAdministratifRepository.deleteById(id);
    }
}
