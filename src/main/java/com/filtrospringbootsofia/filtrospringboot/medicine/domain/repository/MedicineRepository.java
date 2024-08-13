package com.filtrospringbootsofia.filtrospringboot.medicine.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.filtrospringbootsofia.filtrospringboot.medicine.persistence.Medicine;

@Repository
public interface MedicineRepository extends CrudRepository<Medicine, Long>{
    
}
