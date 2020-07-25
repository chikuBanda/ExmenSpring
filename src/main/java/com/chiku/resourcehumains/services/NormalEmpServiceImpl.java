package com.chiku.resourcehumains.services;

import com.chiku.resourcehumains.entities.NormalEmp;
import com.chiku.resourcehumains.exceptions.ResourceNotFoundException;
import com.chiku.resourcehumains.repositories.NormalEmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NormalEmpServiceImpl implements NormalEmpService{
    @Autowired
    NormalEmpRepository normalEmpRepository;

    @Override
    public void save(NormalEmp normalEmp) {
        normalEmpRepository.save(normalEmp);
    }

    @Override
    public List<NormalEmp> getEmps() {
        return (List<NormalEmp>) normalEmpRepository.findAll();
    }

    @Override
    public NormalEmp findById(long id) throws ResourceNotFoundException {
        return (NormalEmp) normalEmpRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException(id)
        );
    }
}
