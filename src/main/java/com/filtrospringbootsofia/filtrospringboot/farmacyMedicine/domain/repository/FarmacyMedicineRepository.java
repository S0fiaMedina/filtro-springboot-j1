package com.filtrospringbootsofia.filtrospringboot.farmacyMedicine.domain.repository;

import org.springframework.data.repository.CrudRepository;

import com.filtrospringbootsofia.filtrospringboot.farmacyMedicine.persistence.FarmacyMedicine;

public interface FarmacyMedicineRepository extends CrudRepository<FarmacyMedicine, Long>{
    
}
