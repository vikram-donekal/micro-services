package com.nokia.microserivice2.nokiamicroserivice2.DTO;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name="city")
public class City implements Serializable {
 

	private static final long serialVersionUID = 6471505062958110264L;

	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id; 
 
	
    private String Location;
    private String Country;
    private int pinCode;
 
    public City(String Location, String Country, int pinCode) {
        this.Location = Location;
        this.Country = Country;
        this.pinCode = pinCode;
    }
    
    
    @Override
    public String toString() {
      return String.format("City[ id=%s, Location=%s, Country=%s, pinCode = %d ]", this.id, this.Location, this.Country,this.pinCode);
    }
    
}