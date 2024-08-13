package com.filtrospringbootsofia.filtrospringboot.region.persistence;

import com.filtrospringbootsofia.filtrospringboot.country.persistence.Country;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table (name = "region")
public class Region {
    
    @Id
    private String codereg;

    private String namereg;

    @ManyToOne
    @JoinColumn( name = "codecountry")
    private Country country;

    
    

}
