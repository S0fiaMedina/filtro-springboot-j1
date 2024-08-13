package com.filtrospringbootsofia.filtrospringboot.customer.persistence;

import java.sql.Date;

import com.filtrospringbootsofia.filtrospringboot.city.persistence.City;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table( name = "customer")
@Data
@NoArgsConstructor
public class Customer {
    
    @Id
    private String idcustomer;

    private String namecustomer;

    private String lastnamecustomer;

    private String emailcustomer;

    private Date birthdate;

    private double lon;

    private double lat;

    // ciudad
    @ManyToOne
    @JoinColumn ( name = "codecitycustomer")
    private City city;


 
}
