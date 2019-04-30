package com.nokia.nokia.DTO;

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
@Table(name="student")
public class Student implements Serializable {
 

	private static final long serialVersionUID = 6471505062958110264L;

	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id; 
 
	
    private String firstName;
    private String lastName;
    private int age;
 
    public Student(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    
    
    @Override
    public String toString() {
      return String.format("Student[ id=%s, firstName=%s, lastName=%s, age = %d ]", this.id, this.firstName, this.lastName,this.age);
    }
    
}