package com.chiku.resourcehumains.services;

import com.chiku.resourcehumains.entities.DepAdminstratif;
import com.chiku.resourcehumains.entities.DepService;
import com.chiku.resourcehumains.exceptions.ResourceNotFoundException;

import java.util.List;

public interface DepServService {
    void save(DepService depService);
    List<DepService> getDeps();
    DepService findById(long id) throws ResourceNotFoundException;
}
