package com.pi.MinuteBrico.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Category")
public class Category {

	@SequenceGenerator(
            name = "Category_sequence",
            sequenceName = "Category_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Category_sequence"
    )
	private int id; 
	private String name;
	
	//private Sous_Category sousCategory;
}
