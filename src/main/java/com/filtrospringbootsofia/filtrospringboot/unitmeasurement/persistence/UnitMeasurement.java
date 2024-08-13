package com.filtrospringbootsofia.filtrospringboot.unitmeasurement.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table ( name = "unitmeasurement")
public class UnitMeasurement {
        
    @Id
    @GeneratedValue( strategy =  GenerationType.IDENTITY)
    private Long idum;

    private String nameum;
}
