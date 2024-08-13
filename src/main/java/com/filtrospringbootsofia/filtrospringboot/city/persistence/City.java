package com.filtrospringbootsofia.filtrospringboot.city.persistence;

import com.filtrospringbootsofia.filtrospringboot.region.persistence.Region;

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
@Table( name = "city")
public class City {

    @Id
    private String codecity; 

    private String namecity; 

    @ManyToOne
    @JoinColumn ( name = "codereg")
    private Region region;


}
