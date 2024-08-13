package com.filtrospringbootsofia.filtrospringboot.farmacyMedicine.persistence;

import com.filtrospringbootsofia.filtrospringboot.farmacy.persistence.Farmacy;
import com.filtrospringbootsofia.filtrospringboot.medicine.persistence.Medicine;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table( name = "farmacymedicine")
public class FarmacyMedicine {

    @Id
    @GeneratedValue( strategy =  GenerationType.IDENTITY)
    private Long farmacymedicineid;

    @ManyToOne
    @JoinColumn( name = "idfarmacy")
    Farmacy farmacy;

    @ManyToOne
    @JoinColumn( name = "idmedicine")
    Medicine medicine;

    double price;


    
}
