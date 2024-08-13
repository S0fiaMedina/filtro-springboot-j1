package com.filtrospringbootsofia.filtrospringboot.medicine.domain.dto;

import java.util.Set;

import com.filtrospringbootsofia.filtrospringboot.activeprinciple.persistence.ActivePrinciple;
import com.filtrospringbootsofia.filtrospringboot.farmacyMedicine.domain.dto.FarmacyMedicineDto;
import com.filtrospringbootsofia.filtrospringboot.laboratory.persistence.Laboratory;
import com.filtrospringbootsofia.filtrospringboot.medicine.persistence.Medicine;
import com.filtrospringbootsofia.filtrospringboot.modeadministration.persistence.ModeAdministration;
import com.filtrospringbootsofia.filtrospringboot.unitmeasurement.persistence.UnitMeasurement;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MedicineDto {
    
    private Long id;

    @NotBlank( message =  "proceedings no puede ser vacio")
    private String proceedings;

    @NotBlank( message =  "namemedicine no puede ser vacio")
    private String nameMedicine;

    @NotBlank( message =  "healthregister no puede ser vacio")
    private String healthRegister;

    @NotBlank( message =  "description no puede ser vacio")
    private String description;

    @NotBlank( message =  "descriptionshort no puede ser vacio")
    private String descriptionShort;

    @NotBlank( message =  "nameRol no puede ser vacio")
    private String nameRol;

    // llaves foraneas

    @NotNull( message =  "modeAdministrationId no puede ser vacio")
    private Long modeAdministrationId;

    @NotNull( message =  "activePrincipleId no puede ser vacio")
    private Long activePrincipleId;

    @NotNull( message =  "unitMeasurementId no puede ser vacio")
    private Long unitMeasurementId;

    @NotNull( message =  "laboratoryId no puede ser vacio")
    private Long laboratoryId;

    @NotNull( message =  "farmacyMedicineDtos no puede ser vacio")
    private Set<FarmacyMedicineDto> pricesFarmacy;


    public static Medicine toMedicine ( MedicineDto dto){

        ModeAdministration modeAm = new ModeAdministration();
        modeAm.setId( dto.getModeAdministrationId());

        UnitMeasurement unitM = new UnitMeasurement();
        unitM.setIdum( dto.getUnitMeasurementId());

        Laboratory lab = new Laboratory();
        lab.setId( dto.getLaboratoryId());

        ActivePrinciple ap = new ActivePrinciple();
        ap.setAp( dto.getActivePrincipleId());


        Medicine newMedicine = Medicine.builder()
            .description(dto.getDescription())
            .descriptionshort( dto.getDescriptionShort())
            .namemedicine( dto.getNameMedicine())
            .healthregister( dto.getHealthRegister())
            .namerol( dto.getNameRol())
            .proceedings( dto.getProceedings())
            .activePrinciple(ap)
            .laboratory(lab)
            .unitMeasurement(unitM)
            .modeAdministration(modeAm)
            .build();

            if ( dto.getId() != null){
                newMedicine.setId( dto.getId());
            }

        return newMedicine;


    }

}
