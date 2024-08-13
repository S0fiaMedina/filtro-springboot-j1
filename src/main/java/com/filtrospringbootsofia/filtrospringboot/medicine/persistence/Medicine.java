package com.filtrospringbootsofia.filtrospringboot.medicine.persistence;

import com.filtrospringbootsofia.filtrospringboot.activeprinciple.persistence.ActivePrinciple;
import com.filtrospringbootsofia.filtrospringboot.laboratory.persistence.Laboratory;
import com.filtrospringbootsofia.filtrospringboot.modeadministration.persistence.ModeAdministration;
import com.filtrospringbootsofia.filtrospringboot.unitmeasurement.persistence.UnitMeasurement;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table (name = "medicine")
public class Medicine {
    @Id
    @GeneratedValue( strategy =  GenerationType.IDENTITY)
    private Long id;

    private String proceedings;

    private String namemedicine;

    private String healthregister;

    private String description;

    private String descriptionshort;
    

    private String namerol;

    // llaves foraneas

    // ap
    @ManyToOne
    @JoinColumn( name = "codeadminmode")
    private ModeAdministration modeAdministration;

    @ManyToOne
    @JoinColumn( name = "codeap")
    private ActivePrinciple activePrinciple;

    //code um

    @ManyToOne
    @JoinColumn( name = "codeum")
    private UnitMeasurement unitMeasurement;

    // lab

    @ManyToOne
    @JoinColumn( name = "codelab")
    private Laboratory laboratory;
    

}
