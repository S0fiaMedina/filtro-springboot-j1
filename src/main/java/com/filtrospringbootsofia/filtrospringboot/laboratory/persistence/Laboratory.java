package com.filtrospringbootsofia.filtrospringboot.laboratory.persistence;

import com.filtrospringbootsofia.filtrospringboot.city.persistence.City;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table ( name = "laboratory")
public class Laboratory {

    @Id
    @GeneratedValue( strategy =  GenerationType.IDENTITY)
    private Long id;

    private String namelab;

    // ciudad
    @ManyToOne
    @JoinColumn ( name = "codecityreg")
    private City city;

    public Laboratory() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamelab() {
        return namelab;
    }

    public void setNamelab(String namelab) {
        this.namelab = namelab;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
 

}
