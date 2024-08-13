package com.filtrospringbootsofia.filtrospringboot.farmacy.persistence;

import com.filtrospringbootsofia.filtrospringboot.city.persistence.City;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table ( name = "farmacy")
@Data
@NoArgsConstructor
public class Farmacy {
    @Id
    @GeneratedValue( strategy =  GenerationType.IDENTITY)
    private Long idfarmacy;

    private String namefarmacy;

    private String addressfarmacy;

    private String logofarmacy;

    private double longfarmacy;

    private double lat;

    @ManyToOne
    @JoinColumn ( name = "codecityfarm")
    private City city;




}
