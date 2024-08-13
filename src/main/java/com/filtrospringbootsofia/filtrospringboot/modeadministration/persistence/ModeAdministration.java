package com.filtrospringbootsofia.filtrospringboot.modeadministration.persistence;

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
@Table ( name = "modeadministration")
public class ModeAdministration {
    
    @Id
    @GeneratedValue( strategy =  GenerationType.IDENTITY)
    private Long id;

    private String descriptionmode;

}
