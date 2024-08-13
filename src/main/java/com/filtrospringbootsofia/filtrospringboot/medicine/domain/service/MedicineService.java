package com.filtrospringbootsofia.filtrospringboot.medicine.domain.service;


import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filtrospringbootsofia.filtrospringboot.farmacyMedicine.domain.dto.FarmacyMedicineDto;
import com.filtrospringbootsofia.filtrospringboot.farmacyMedicine.domain.repository.FarmacyMedicineRepository;
import com.filtrospringbootsofia.filtrospringboot.farmacyMedicine.persistence.FarmacyMedicine;
import com.filtrospringbootsofia.filtrospringboot.medicine.domain.dto.MedicineDto;
import com.filtrospringbootsofia.filtrospringboot.medicine.domain.repository.MedicineRepository;
import com.filtrospringbootsofia.filtrospringboot.medicine.persistence.Medicine;

@Service
public class MedicineService {

    @Autowired
    MedicineRepository medicineRepository;

    @Autowired
    FarmacyMedicineRepository farmacyMedicineRepository;

    // find by id
    public Optional<Medicine> findById(Long id){
        return this.medicineRepository.findById(id);
    }

    // FIND ALL 
    public List<Medicine> findAll(){
        return (List<Medicine>) this.medicineRepository.findAll();
    }


    public Optional<Medicine> delete(Long id){
        Optional<Medicine> optionalMedicine = this.medicineRepository.findById( id);

       if (optionalMedicine.isPresent()){
            this.medicineRepository.delete( optionalMedicine.get());
            return optionalMedicine;
       }

       return Optional.empty();
    }

    public Medicine save(MedicineDto dto){
        return this.createMedicine( dto);
    }

    public Optional<Medicine> update(MedicineDto dto, Long id){

        Optional<Medicine> optionalMedicine = this.medicineRepository.findById( id);

        if (optionalMedicine.isPresent()){

            dto.setId( optionalMedicine.get().getId());
            Medicine updateMedicine = this.createMedicine(dto);
            return Optional.of(updateMedicine);

        }

        return Optional.empty();
    }
    

    private Medicine createMedicine ( MedicineDto medDto){
        Medicine newMedicine = this.medicineRepository.save(MedicineDto.toMedicine(medDto));

        // convertir dtos de tabla intermedia
        Set<FarmacyMedicine> dtos = medDto.getPricesFarmacy().stream()
            .map( dto ->{
                dto.setIdMedicine( newMedicine.getId());
                FarmacyMedicine fm = FarmacyMedicineDto.toEntity(dto);
                return fm;
            })
            .collect( Collectors.toSet());
        
            this.farmacyMedicineRepository.saveAll(dtos);
        
        return newMedicine;
    }
}
