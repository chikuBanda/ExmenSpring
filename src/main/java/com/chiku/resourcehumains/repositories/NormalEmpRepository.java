package com.chiku.resourcehumains.repositories;

import com.chiku.resourcehumains.entities.NormalEmp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NormalEmpRepository extends JpaRepository<NormalEmp, Long> {
}
