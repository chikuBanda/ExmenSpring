package com.chiku.resourcehumains.services;

import com.chiku.resourcehumains.entities.DepAdminstratif;
import com.chiku.resourcehumains.entities.Manager;
import com.chiku.resourcehumains.exceptions.ResourceNotFoundException;

import java.util.List;

public interface DepAdministratifService {
    void save(DepAdminstratif depAdminstratif);
    List<DepAdminstratif> getDeps();
    DepAdminstratif findById(long id) throws ResourceNotFoundException;
}
