package com.filtrospringbootsofia.filtrospringboot.country.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table( name = "country")
public class Country {
    
    @Id
    private String codecountry;
    private String namecountry;


    public Country() {
    }
    
    public String getCodecountry() {
        return codecountry;
    }
    public void setCodecountry(String codecountry) {
        this.codecountry = codecountry;
    }
    public String getNamecountry() {
        return namecountry;
    }
    public void setNamecountry(String namecountry) {
        this.namecountry = namecountry;
    }    

}
