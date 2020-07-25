package com.chiku.resourcehumains.repositories;

import com.chiku.resourcehumains.entities.DepAdminstratif;
import com.chiku.resourcehumains.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepAdministratifRepository extends JpaRepository<DepAdminstratif, Long> {
}
