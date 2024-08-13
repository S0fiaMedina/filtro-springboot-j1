package com.filtrospringbootsofia.filtrospringboot.farmacyMedicine.domain.dto;

import com.filtrospringbootsofia.filtrospringboot.farmacy.persistence.Farmacy;
import com.filtrospringbootsofia.filtrospringboot.farmacyMedicine.persistence.FarmacyMedicine;
import com.filtrospringbootsofia.filtrospringboot.medicine.persistence.Medicine;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FarmacyMedicineDto {
    Long farmacyMedicineId;
    
    @NotNull( message =  "El id de la farmacia no puede ser nulo")
    Long idFarmacy;

    Long idMedicine;

    @NotNull ( message =  "El precio no puede ser nulo")
    double price;

    public static FarmacyMedicine toEntity( FarmacyMedicineDto dto){

        // medicina
        Medicine med = new Medicine();
        med.setId( dto.getIdMedicine() );

        // farmacia
        Farmacy farm = new Farmacy();
        farm.setIdfarmacy( dto. getIdFarmacy());
        
        FarmacyMedicine  fm = FarmacyMedicine.builder()
            .medicine(med)
            .farmacy(farm)
            .price(dto.getPrice())
            .build();

        if ( dto.getFarmacyMedicineId() != null){
            fm.setFarmacymedicineid( dto.getFarmacyMedicineId() );
        }

        return fm;
    }
}
